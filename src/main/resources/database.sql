
create table ingredient(
    id int(11) not null AUTO_INCREMENT,
    name varchar(100) not null,
    primary key(id)
);


create table recipe(
    id int(11) not null AUTO_INCREMENT,
    name varchar(200) null,
    description varchar(250) null,
    image_url varchar(250) null,
    primary key(id)
    
);
create table recipe_ingredient(
    id int(11) not null AUTO_INCREMENT,
    name varchar(100) not null,
    amount int not null,
    ingredient_id int not null,
    recipe_id int not null,
    primary key(id),
    foreign key(ingredient_id) references ingredient(id),
        foreign key(recipe_id) references recipe(id)
    
    
);