clc; clear; close all;
pkg load control;  % Только для Octave

set(0, "defaultaxesfontname", "Arial");
set(0, "defaulttextfontname", "Arial");

%% 0. Параметры
a = 2;
t1 = 4;
t2 = 8;
b = 0.0;
c = 2.0;
d = 10;

w0 = 10;
a1 = 0;
a2 = w0^2;
b2 = w0^2;
b1 = 2;

%% 1. Параметры сигнала
T_interval = 100;
dt = 0.01;
t = -T_interval/2 : dt : T_interval/2;
L = length(t);
Fs = 1/dt;
f = Fs * (-L/2 : L/2 - 1) / L;
w = 2 * pi * f;

%% g(t)
g = zeros(size(t));
g(t >= t1 & t <= t2) = a;

%% Генерация шума
rng(42);  % Современный способ инициализации генератора случайных чисел
xi = 2*rand(size(t)) - 1;  % равномерный шум [-1,1]
sine_noise = c * sin(d * t);
u = g + b * xi + sine_noise;

%% Функция FFT
function res = calc_fft(sig, len)
    res = fftshift(fft(sig)) / len;
endfunction

G_w = calc_fft(g, L);
U_w = calc_fft(u, L);

%% Создание передаточной функции фильтра
sys2 = tf([1, a1, a2], [1, b1, b2]);
y2 = lsim(sys2, u, t);
Y2_w = calc_fft(y2, L);

%% Частотная характеристика фильтра
s_val = 1i * w;
W2_freq = (s_val.^2 + a1*s_val + a2) ./ (s_val.^2 + b1*s_val + b2);

%% Построение графиков
figure(2);

% Временные сигналы
subplot(3,1,1);
plot(t, g, 'k', 'linewidth', 2); hold on;
plot(t, u, 'color', [0.6 0.6 0.6]);
plot(t, y2, 'b', 'linewidth', 1.5);
title(['Задание 1.2: Режекторный фильтр (b1 = ' num2str(b1) '; d = ' num2str(d) ')']);
legend('Исходный g(t)', 'Зашумленный u(t)', 'Фильтрованный y(t)');
xlim([-15 15]); grid on;

% Спектры
subplot(3,1,2);
plot(w, abs(U_w), 'color', [0.6 0.6 0.6]); hold on;
plot(w, abs(Y2_w), 'b', 'linewidth', 1.5);
yl = ylim;
plot([w0 w0], yl, 'r--'); plot([-w0 -w0], yl, 'r--');
title(['Спектры: удаление помехи  (b1 = ' num2str(b1) '; d = ' num2str(d) ')']);
legend('|u(\omega)|', '|y(\omega)|', 'Целевая частота');
xlim([-20 20]);
ylim([0 0.15]); grid on;

% Проверка через теорию
subplot(3,1,3);
Y2_theory = W2_freq .* U_w;
plot(w, abs(Y2_w), 'r', 'linewidth', 2); hold on;
plot(w, abs(Y2_theory), 'b--');
plot(w, abs(W2_freq), 'g', 'linewidth', 1);
title(['АЧХ  (b1 = ' num2str(b1) '; d = ' num2str(d) ')']);
legend('FFT(Выход)', 'W(i\omega) * FFT(Вход)', 'АЧХ Фильтра');
xlabel('Частота \omega (рад/с)');
xlim([0 20]); grid on;

%% Сохранение графика
set(gcf, 'PaperPosition', [0 0 12 12]);
filename = ['signals_1.2_(b1=' num2str(b1) '; d=' num2str(d) ').svg'];
print(gcf, filename, '-dsvg','-r1200');

