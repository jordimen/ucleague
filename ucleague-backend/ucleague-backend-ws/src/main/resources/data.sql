insert into COUNTRY(code, name) values('ES','Spain');
insert into COUNTRY(code, name) values('FR','France');
insert into COUNTRY(code, name) values('PT','Portugal');
insert into COUNTRY(code, name) values('IT','Italy');
insert into COUNTRY(code, name) values('DE','Germany');
insert into COUNTRY(code, name) values('GB','Germany');
insert into COUNTRY(code, name) values('NL','Netherlands');

insert into TEAM(id, name, country_code) values(1,'Real Madrid', 'ES');
insert into TEAM(id, name, country_code) values(2,'FC Barcelona', 'ES');
insert into TEAM(id, name, country_code) values(3,'Bayern München', 'DE');
insert into TEAM(id, name, country_code) values(4,'Chelsea Football Club', 'GB');
insert into TEAM(id, name, country_code) values(5,'AC Milan', 'IT');
insert into TEAM(id, name, country_code) values(6,'Manchester United FC', 'GB');
insert into TEAM(id, name, country_code) values(7,'Liverpool FC', 'GB');
insert into TEAM(id, name, country_code) values(8,'FC Oporto', 'PT');
insert into TEAM(id, name, country_code) values(9,'Juventus FC', 'IT');
insert into TEAM(id, name, country_code) values(10,'AFC Ajax', 'NL');

update TEAM set rival_id = 2 where id = 1;
update TEAM set rival_id = 1 where id = 2;

insert into CHAMPIONSHIP(year, winner_id) values('2017', 1);
insert into CHAMPIONSHIP(year, winner_id) values('2016', 1);
insert into CHAMPIONSHIP(year, winner_id) values('2015', 2);
insert into CHAMPIONSHIP(year, winner_id) values('2014', 1);
insert into CHAMPIONSHIP(year, winner_id) values('2013', 3);
insert into CHAMPIONSHIP(year, winner_id) values('2012', 4);
insert into CHAMPIONSHIP(year, winner_id) values('2011', 2);
insert into CHAMPIONSHIP(year, winner_id) values('2010', 5);

