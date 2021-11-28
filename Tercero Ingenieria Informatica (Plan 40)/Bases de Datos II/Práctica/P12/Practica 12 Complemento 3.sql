with
   a as (select sn, pn, sum(cantidad) as totcant
         from spj
         group by sn, pn),
   b as (select pn, max(totcant) as maxcant
         from a
         group by pn),
   c as (select a.pn, sn, maxcant
         from a, b
         where a.pn=b.pn
         and   a.totcant=b.maxcant)
select pnombre, snombre, maxcant
from p, c, s
where p.pn=c.pn
and   s.sn=c.sn;