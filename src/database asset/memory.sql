create  database memoryG;
use memoryG;

create table player (
player_id int auto_increment primary key,
birth_date      date,
username      varchar(50) unique,
p_password      varchar(50)
);

create table game (
game_id    int auto_increment primary key,     /* primary key */       
player_id    int , /*foreign key*/
score         int,
);







           
-- foreign keys ---

alter table game 
add foreign key (player_id) references player(player_id);


alter table activity
add foreign key (game_id) references game(game_id);


-- end foreign key ---

