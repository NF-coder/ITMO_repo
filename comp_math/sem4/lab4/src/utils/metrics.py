import numpy as np


def sse(y_true: np.ndarray, y_pred: np.ndarray) -> float:
    return float(np.sum((y_pred - y_true) ** 2))


def mse(y_true: np.ndarray, y_pred: np.ndarray) -> float:
    return float(np.mean((y_pred - y_true) ** 2))


def rmse(y_true: np.ndarray, y_pred: np.ndarray) -> float:
    return float(np.sqrt(mse(y_true, y_pred)))


def r_squared(y_true: np.ndarray, y_pred: np.ndarray) -> float:
    mean_y = np.mean(y_true)
    ss_tot = np.sum((y_true - mean_y) ** 2)
    if ss_tot == 0:
        return 0.0
    return float(1 - (np.sum((y_true - y_pred) ** 2) / ss_tot))


def pearson_r(x: np.ndarray, y: np.ndarray) -> float:
    x_mean = np.mean(x)
    y_mean = np.mean(y)
    cov = np.sum((x - x_mean) * (y - y_mean))
    std_x = np.sqrt(np.sum((x - x_mean) ** 2))
    std_y = np.sqrt(np.sum((y - y_mean) ** 2))
    if std_x == 0 or std_y == 0:
        return 0.0
    return float(cov / (std_x * std_y))