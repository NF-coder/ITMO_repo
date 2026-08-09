clc; clear; close all;
pkg load control;

set(0, "defaultaxesfontname", "Arial");
set(0, "defaulttextfontname", "Arial");

filename = 'SBER.csv';
fid = fopen(filename);
data_cells = textscan(fid, '%s %f %f %f %f %f %f %f %f', 'Delimiter', ';', 'HeaderLines', 1);
fclose(fid);

prices = data_cells{8};
dt = 1;
time_steps = 0 : dt : (length(prices)-1)*dt;

T_values = [9, 45, 180, 540, 2160];
labels = {'1 День', '1 Неделя', '1 Месяц', '3 Месяца', '1 Год'};
plot_colors = lines(length(T_values) + 1);

figure(3);
plot(time_steps, prices, 'color', [0.8 0.8 0.8], 'linewidth', 2); hold on;
legend_entries = {'Исходные данные'};

for i = 1:length(T_values)
    T = T_values(i);
    sys = tf(1, [T 1]);

    start_val = prices(1);
    prices_zeroed = prices - start_val;
    y_zeroed = lsim(sys, prices_zeroed, time_steps);
    y_filtered = y_zeroed + start_val;

    plot(time_steps, y_filtered, 'color', plot_colors(i+1,:), 'linewidth', 2);
    legend_entries{end+1} = ['T = ' labels{i}];
end

title('Сглаживание котировок Сбербанка');
xlabel('Время (торговые часы)');
ylabel('Цена (Руб.)');
grid on;
legend(legend_entries, 'location', 'northwest');

set(gcf, 'PaperPosition', [0 0 20 12]);
filename = ['signals_2.svg'];
print(gcf, filename, '-dsvg','-r1200');
