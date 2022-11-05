# Getting Started

### Usage

- Running the application is the only option.
- Postman not %100 supported with oauth I will have to work on it, a "JSESSIONID" has to be moved from browser to postman cookies.
- Working on a docker-compose to ease the test.
- Try not to change the port, it's not %100 dynamic yet.

Mean time use the **browser** and follow the below endpoints.

#### JDK Used: openjdk-19

#

#### Endpoints

| Name                | Endpoint                                             | Auth Required | Notes                    |
| ------------------- | ---------------------------------------------------- | ------------- | ------------------------ |
| Login               | http://localhost:8080/login                          | No            | A browser is a must here |
| Get Users           | http://localhost:8080/api/v1/users                   | Yes           |
| Get My Info         | http://localhost:8080/api/v1/users/me                | Yes           |
| Get User's Posts    | http://localhost:8080/api/v1/users/{userId}/posts    | Yes           |
| Get Posts           | http://localhost:8080/api/v1/posts/                  | Yes           |
| Get Post's Comments | http://localhost:8080/api/v1/posts/{postId}/comments | Yes           |
| Get Comments        | http://localhost:8080/api/v1/comments                | Yes           |

##

### For any questions please reach me out @ almana@khaled.sh
