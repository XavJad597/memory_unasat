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
score       int 
);


create table activity (
activity_id     int auto_increment primary key ,/*primary key*/
player_id       int ,/*foreign key*/
game_id         int,  /*foreign key*/
round_play       int
);


create table game_levels (
game_level_id       int auto_increment primary key,
player_id           int,
game_id             int ,
game_played          int
);


           
-- foreign keys ---


alter table game 
add foreign key (player_id) references player(player_id);

alter table activity
add foreign key (player_id) references player(player_id);

alter table activity
add foreign key (game_id) references game(game_id);


alter table game_levels
add foreign key (game_id) references game(game_id);


alter table game_levels
add foreign key (player_id) references player(player_id);

-- end foreign key ---

