
# University Course Registration System

This is a simple Java-based system to handle course registrations at a university.

## Setup Instructions:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/UniversityCourseRegistration.git

# Add any additional setup commands here

### Configure the database:

    Update application.properties with your database credentials.




#### Add commands to start the application via command line

      mvn spring-boot:run


#### API Documentation:

#### 1 Register Student for a Course:

   Endpoint: http://localhost:8080/students/register

   Method: POST

   Request Example:
  
     {
      "firstName": "Pranjal",
      "lastName": "Nimkar"",
      "email": "pranjal@gmail.com",
}


   Response Example:
   
    {
      "studentId": 1,
      "firstName": "Pranjal",
      "lastName": "Nimkar",
      "email": "pranjal@gmail.com",
    }
#### 2. Get Courses for a Student:

   Endpoint: http://localhost:8080/enrollments/getCourseForStudent/{studentId}

   Method: GET

   Response Example:

  
    [
    {
        "enrollmentId": 1,
        "student": {
            "studentId": 1,
            "firstName": "Pranjal",
            "lastName": "Nimkar",
            "email": "pranjal@gmail.com"
        },
        "course": {
            "courseCode": 1,
            "courseName": "Advanced Java Programming",
            "instructor": "XYZ"
        },
        "deleted": false
    },
    {
        "enrollmentId": 2,
        "student": {
            "studentId": 1,
            "firstName": "Pranjal",
            "lastName": "Nimkar",
            "email": "pranjal@gmail.com"
        },
        "course": {
            "courseCode": 3,
            "courseName": "Python",
            "instructor": "XYZ"
        },
        "deleted": false
    }
]


#### 3 Add New Course:

   Endpoint: http://localhost:8080/courses/add

   Method: POST

   Request Example:

    {
        "courseName": "Advanced Java Programming",
        "instructor": "XYZ",
        "credits": 3
     }

   Response Example:

    {
        "courseCode": "CS202",
        "courseName": "Advanced Java Programming",
        "instructor": "XYZ",
        "credits": 3
   }

#### 4 Enroll Student in a Course:

   Endpoint: http://localhost:8080/enrollments/enroll/{studentId}/{courseCode}

   Method: POST

   Response Example:
  
    {
    "enrollmentId": 1,
    "student": {
        "studentId": 1,
        "firstName": "Pranjal",
        "lastName": "Nimkar",
        "email": "pranjal@gmail.com"
    },
    "course": {
        "courseCode": 3,
        "courseName": "Python",
        "instructor": "XYZ"
    },
      "deleted": false
    }

#### 5 Delete Enrollment:

   Endpoint: http://localhost:8080/enrollments/delete/{enrollmentId}

   Method: DELETE

   Response Example:
   
    {
        "message": "Enrollment deleted successfully."
    }

#### 5 Update Enrollment:

Endpoint: http://localhost:8080/enrollments/update/{enrollmentId}

Method: POST

Request Example:

      {
         "studentId": 0,
         "courseCode": 0
      }

Response Example:

    {
        "message": "Enrollment deleted successfully."
    }