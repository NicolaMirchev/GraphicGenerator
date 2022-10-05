CREATE TABLE courses
(
	name text PRIMARY KEY,
	times_per_week integer NOT NULL,
)

CREATE TABLE course_option
(
	course text,
	weekday text,
	starting_time timestamp,
	graphic integer,
	
	CONSTRAINT pk_course_option PRIMARY KEY (course, weekday, starting_time),
	CONSTRAINT fk_course FOREIGN KEY (course) REFERENCES courses(name),
	CONSTRAINT fk_graphic FOREIGN KEY (graphic) REFERENCES graphic(id)
)

CREATE TABLE graphic
(
	id integer GENERATED ALWAYS AS IDENTITY,
	gap_rate serial 
)