#set page(width: 20cm, height: auto, fill: color.hsl(65.63deg, 100%, 93.73%), margin: 15pt)
#set align(left + top)
= З2. Отрицание критерия Коши сходимости числового ряда

Ряд $sum_(k=1)^infinity a_k$ расходится тогда и только тогда, когда

$ exists ε > 0 : forall n_0 in NN 
  exists n > n_0, 
  exists p in NN : 
  abs( sum_(k=n+1)^(n+p) a_k ) >= epsilon $