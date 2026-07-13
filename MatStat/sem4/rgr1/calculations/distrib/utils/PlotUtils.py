from collections.abc import Sequence
from typing import Dict, Optional, Tuple

import matplotlib.pyplot as plt


class PlotUtils:
    @staticmethod
    def plot_density_histograms(
        groups: Dict[str, Sequence[float]],
        bins: int = 30,
        figsize: Tuple[int, int] = (12, 8),
        density: bool = True,
        alpha: float = 0.7,
        colors: Optional[Dict[str, str]] = None,
        suptitle: Optional[str] = None,
    ) -> None:
        if not groups:
            return

        labels = list(groups.keys())
        values = list(groups.values())
        n = len(labels)
        ncols = 2
        nrows = (n + ncols - 1) // ncols

        fig, axes = plt.subplots(nrows, ncols, figsize=figsize)
        if nrows == 1:
            axes = [axes]
        else:
            axes = axes.flatten()

        for idx, label in enumerate(labels):
            ax = axes[idx]
            ax.hist(values[idx], bins=bins, density=density, alpha=alpha, color=(colors or {}).get(label, None))
            ax.set_title(label)
            ax.set_xlabel('Value')
            ax.set_ylabel('Density' if density else 'Count')
            ax.grid(True, linestyle='--', alpha=0.3)

        for idx in range(len(labels), len(axes)):
            fig.delaxes(axes[idx])

        if suptitle:
            fig.suptitle(suptitle)
        fig.tight_layout(rect=[0, 0, 1, 0.96] if suptitle else None)

    @staticmethod
    def plot_scatter(
        x: Sequence[float],
        y: Sequence[float],
        x_label: str = 'x',
        y_label: str = 'y',
        title: Optional[str] = None,
        label: Optional[str] = None,
        color: str = 'blue',
        alpha: float = 0.5,
        figsize: Tuple[int, int] = (8, 6),
    ) -> None:
        fig, ax = plt.subplots(figsize=figsize)
        ax.scatter(x, y, label=label, color=color, alpha=alpha)
        ax.set_xlabel(x_label)
        ax.set_ylabel(y_label)
        if title:
            ax.set_title(title)
        if label:
            ax.legend()
        ax.grid(True, linestyle='--', alpha=0.3)

    @staticmethod
    def plot_boxplots(
        groups: Dict[str, Sequence[float]],
        figsize: Tuple[int, int] = (12, 5),
        title: Optional[str] = None,
        ylabel: Optional[str] = None,
    ) -> None:
        if not groups:
            return

        fig, ax = plt.subplots(figsize=figsize)
        ax.boxplot(list(groups.values()), labels=list(groups.keys()), patch_artist=True)
        if title:
            ax.set_title(title)
        if ylabel:
            ax.set_ylabel(ylabel)
        ax.grid(True, linestyle='--', alpha=0.3)
        fig.tight_layout()