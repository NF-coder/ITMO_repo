#set page(width: 20cm, height: auto, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T24\*. Формула Коши-Адамара

Пусть дан степенной ряд с общим членом $a_k x^k$. Тогда

$ R = 1 / (overline(lim_(k -> infinity)) root(k, |a_k|)) $

*Доказательство.* Воспользуемся радикальным признаком Коши (131). Найдем

$ l = overline(lim_(k -> infinity)) root(k, |a_k x^k|) = |x| overline(lim_(k -> infinity)) root(k, |a_k|) $

Если $l < 1$, то ряд сходится, причем абсолютно. Если $l > 1$, то ряд расходится, так как его общий член не стремится к нулю. Если договориться, что $1/0 = +infinity$, $1/(+infinity) = 0$, то последнее равносильно неравенствам

$ |x| < 1/(overline(lim_(k -> infinity)) root(k, |a_k|)) quad text(и) quad |x| > 1/(overline(lim_(k -> infinity)) root(k, |a_k|)) $

соответственно, что и доказывает теорему.