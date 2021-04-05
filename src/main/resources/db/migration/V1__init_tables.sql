create table policy
(id int8 not null,
 contract_date date not null,
 contract_duration int8 not null,
 end_date date,
 owner_name varchar(255),
 start_date date,
 policy_type_id int8,
 insured_obj_id int8, primary key (id)
);

create table policy_type
(id int8 not null,
 type_name varchar(255),
 insured_obj_id int8,
 primary key (id)
);

create table insured_object
(id int8 not null,
 object_name varchar(255), primary key (id)
);


alter table if exists policy
    add constraint policy_type_fkey foreign key (policy_type_id) references policy_type;

alter table if exists policy
    add constraint insured_object_fkey foreign key (insured_obj_id) references insured_object;

alter table if exists policy_type
    add constraint insured_object_fkey foreign key (insured_obj_id) references insured_object;


insert into insured_object values (1,'VEHICLE');
insert into insured_object values (2,'REAL ESTATE');
insert into insured_object values (3,'PROPERTY');


insert into policy_type values (1,'COLLISION COVERAGE',1);
insert into policy_type values (2,'COMPREHENSIVE COVERAGE',1);
insert into policy_type values (3,'FLOOD COVERAGE',2);
insert into policy_type values (4,'COMPLEX COVERAGE',2);
insert into policy_type values (5,'EARTHQUAKE COVERAGE',2);
insert into policy_type values (6,'THEFT COVERAGE',3);
insert into policy_type values (7,'FIRE COVERAGE',3);




