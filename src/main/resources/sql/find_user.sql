select u.firstname, u.middlename, u.secondname, ci.name, c.color, c.model
from users u,
cars c,
inter i,
cities ci
where
u.id = i.user_id
and c.id = i.car_id
and ci.id = u.city_id