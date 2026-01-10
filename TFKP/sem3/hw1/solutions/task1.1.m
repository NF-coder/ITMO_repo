% Задание 1. Линейные фильтры 

clc; clear; close all;
pkg load control;
pkg load signal;

set(0, "defaultaxesfontname", "Arial");
set(0, "defaulttextfontname", "Arial");


% 0. Параметры
a = 2;
t1 = 4;
t2 = 8;
b = 1.0;
c = 0.0;
d = 10;  


% 1. Параметры сигнала
T_interval = 100;
dt = 0.01;
t = -T_interval/2 : dt : T_interval/2;

% g(t)
g = zeros(size(t));
g(t >= t1 & t <= t2) = a;

% Генерация
rand('state', 42);
xi = 2*rand(size(t)) - 1;
sine_noise = c * sin(d * t);
u = g + b * xi + sine_noise;

% FFT
Fs = 1/dt;
L = length(t);
f = Fs * (-L/2 : L/2 - 1) / L;
w = 2 * pi * f;

function res = calc_fft(sig, len)
    res = fftshift(fft(sig)) / len;
endfunction

G_w = calc_fft(g, L);
U_w = calc_fft(u, L);


% 1.1 Фильтр первого порядка

T_filter = 3;

sys1 = tf(1, [T_filter 1]);
y1 = lsim(sys1, u, t);
Y1_w = calc_fft(y1, L);
W1_freq = 1 ./ (1i *w * T_filter + 1);

figure(1);

subplot(3,1,1);
plot(t, g, 'k', 'linewidth', 2); hold on;
plot(t, u, 'color', [0.6 0.6 0.6]); 
plot(t, y1, 'r', 'linewidth', 1.5);
title(['Задание 1.1: Сигналы во времени (T =' num2str(T_filter) ', a = ' num2str(a) ')']);
legend('Исходный g(t)', 'Зашумленный u(t)', 'Фильтрованный y(t)');
xlim([0 20]); grid on;

subplot(3,1,2);
plot(w, abs(G_w), 'k', 'linewidth', 1.5); hold on;
plot(w, abs(U_w), 'color', [0.6 0.6 0.6]);
plot(w, abs(Y1_w), 'r', 'linewidth', 1.5);
title(['Модули Фурье-образов (T =' num2str(T_filter) ', a = ' num2str(a) ')']);
legend('|g(\omega)|', '|u(\omega)|', '|y(\omega)|');
xlim([0 20]); grid on;

subplot(3,1,3);
Y1_theory = W1_freq .* U_w;
plot(w, abs(Y1_w), 'r', 'linewidth', 2); hold on;
plot(w, abs(Y1_theory), 'b--');
plot(w, abs(W1_freq), 'g', 'linewidth', 1); 
title(['АЧХ (T =' num2str(T_filter) ', a = ' num2str(a) ')']);
legend('FFT(Выход)', 'W(i\omega) * FFT(Вход)', 'АЧХ Фильтра');
xlim([0 20]); grid on;

set(gcf, 'PaperPosition', [0 0 12 12]);
filename = ['signals_1.1_(T=' num2str(T_filter) ',a=' num2str(a) ').svg'];
print(gcf, filename, '-dsvg','-r1200');