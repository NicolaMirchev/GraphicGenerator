# ScheduleGenerator

# Project Main Idea

The idea of the project came after the first week in university and the struggle to find the best combination for attending all the courses that I had been assigned for. The task is complex, because for each course there are few groups (in different time), which can be visited.

Also, many times the personal schedule, given to you from university, assigns two lectures (courses) in a single hour (e.g "Data structures" and "Data bases" at 13:30 on Monday). So, I decided to practice my skills with the technology I had been learning in this moment (Spring Boot), the ability to present the entities in the best possible way for the computer and to choose the best data structures and algorithms, so the project could give you the BEST SCHEDULE (with shortest gaps), based on given courses and options when to attend them.

What the program does is generating all possible combinations for attending the given courses and after that chooses the best option for the user (at this moment there are two options - less gaps, but more days at the univirsity, or bigger gap some day/s, but less days at university).

# Used Technologies

The first idea was only to exercise with Sping Boot and Spring Data JPA, so the back-end is Spring application, consisting of different packages- for cotrollers (REST API), services (where the algorithms about the combinations are executed) and percistance, where are the repositories, related to the data base. For development proccess I used postgres docker container. I made unit tests for each and after each service algorithm implementation, to be sure they work.

I wanted to make some UI, where anyone could check their schedule and decided to practice with Angular, because I had previous experience. I decided that for the "first release" the project will be simpler and DB connection won't be necessary and the whole requiered data will be collected from the browser and sent at once through request. The application procceeds the data in the service layer and return a result which is based on the client browser collected data.

# Next Updates

Optimization
The entity model is more complex than the model used for this release and the algorithms use the complex model. This means that there is a conversion from one model to the other, before executing the algorithms, which slows down the proccess. The one solution that I have in mind is make the algorithms more generic and abstract. Another one is to migrate the model, when there are more complex features, so the more complex model could be used.

Features
See all possible combinations - This feature will be easy to implement, because to find the best schedule, there is already a written logic to generate all the combinations. But I am not sure if this feature will be useful, rather than confusing.

Login/Logout - respectively assign courses to given user (instead of the browser) - This feature will help me exercise with Spring Security, composition and relation between the objects in the application. The feature requires "login","logout", "my courses", "my schedule" views, so it will require more time to be implemented.

Better user experience on signing the courses. What will give a user better experince would be an option to select how many hours of the given course are requiered per week. Also, upload the data in some way, instead of writing it all by hand.
