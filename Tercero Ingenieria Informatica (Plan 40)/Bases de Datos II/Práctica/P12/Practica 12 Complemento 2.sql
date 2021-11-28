select ciudad, max(situacion) situacion, (select snombre
                                          from s
                                          where ciudad=x.ciudad
                                          and (ciudad, situacion) = (select ciudad, max(situacion) 
                                                                     from s
                                                                     group by ciudad
                                                                     having ciudad=x.ciudad)) snombre
from s x
group by ciudad;

select ciudad, max(situacion) situacion, (select snombre
                                          from s
                                          where ciudad=x.ciudad
                                          and (ciudad, situacion) in (select ciudad, max(situacion)
                                                                      from s
                                                                      group by ciudad)) snombre
from s x
group by ciudad;