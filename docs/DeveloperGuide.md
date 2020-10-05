---
layout: page
title: Developer Guide
---
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Appendix A: Product Scope

**Target user profile**:

* university students applying for tech internships
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps

**Value proposition**: Improves your planning, confidence and readiness for tech-related internship applications by
 improving your interview skills and search strategy.

## Appendix B: User Stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​    | I want to …​                                                   | So that I can…​                                                                   |
| -------- | ---------- | -------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `* * *`  | new user   | see usage instructions                                         | refer to instructions when I forget how to use the App                            |
| `* * *`  | user       | get error feedback when a command fails                        | know what went wrong                                                              |
| `* * *`  | user       | add a company profile                                          | keep track of companies that I'm interested in                                    |
| `* * *`  | user       | delete a company profile                                       | remove company profiles that I no longer need / am no longer interested in        |
| `* * *`  | user       | edit a company profile                                         | keep my company profiles updated and accurate                                     |
| `* * *`  | user       | view a company profile                                         |                                                                                   |
| `* * *`  | user       | add an internship application                                  | keep track of the internships that I have applied for                             |
| `* * *`  | user       | delete an internship application                               | remove internship applications that I no longer need / am no longer interested in |
| `* * *`  | user       | edit an internship application                                 | keep my internship applications updated and accurate                              |
| `* * *`  | user       | view an internship application                                 |                                                                                   |
| `* * *`  | user       | track an internship application's status                       |                                                                                   |
| `* * *`  | user       | save the dates of my upcoming interviews                       | keep track of them                                                                |
| `* * *`  | user       | see a list of my skills and achievements                       | understand which internships are a better fit for me                              |
| `* * *`  | user       | add to my list of skills and achievements                      | keep my list of skills and achievements updated and accurate                      |
| `* * *`  | user       | delete a skill / achievement                                   | keep my list of skills and achievements updated and accurate                      |
| `* * *`  | user       | edit a skill / achievement                                     | keep my list of skills and achievements updated and accurate                      |
| `* * *`  | user       | view a skill / achievement                                     |                                                                                   |
| `* *`    | user       | navigate the application easily through a clear user interface |                                                                                   |
| `* *`    | user       | get fast feedback from the app                                 |                                                                                   |


## Appendix C: Use Cases

(For all use cases below, the **System** is `InternHunter` and the **Actor** is the `user`)

### Use case: UC01 - Add a company profile

#### MSS

Guarantees: Addition of company profile is successful

1. User requests to add a company profile and provides company details. 
2. InternHunter adds the company profile.<br/>
Use case ends.

#### Extensions

1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.
    		
### Use case: UC02 - Delete a company profile

#### MSS

Precondition: User already has an existing list of company profiles <br/>
Guarantees: Deletion of company profile is successful

1. User requests to delete a company profile.
2. InternHunter removes the company profile from the list.<br/>
Use case ends.
    
#### Extensions

1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.

### Use case: UC03 - View a company profile

##### MSS

Precondition: User already has an existing list of company profiles <br/>
Guarantees: Viewing of company profile is successful

1. User requests to view a company profile.
2. InternHunter displays the company profile.<br/>
Use case ends.

####  Extensions

1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.

### Use case: UC04 - Edit a company profile

##### MSS

Precondition: User already has an existing list of company profiles <br/>
Guarantees: Editing of company profile is successful

1. User requests to edit the details of a company profile
2. InternHunter edits the details of this internship application. <br/>
Use case ends.

####  Extensions

1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.

### Use case: UC05 - Add an internship application

#### MSS

Guarantees: Adding of internship application is successful

1.  User requests to add an internship application and provides the relevant details.
2.  InternHunter adds the internship application to the list of internship applications.
    Use case ends.

#### Extensions

1a. InternHunter detects an invalid input. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

### Use case: UC06 - Delete an internship application

#### MSS

Precondition: User already has an existing list of internship applications <br />
Guarantees: Deletion of internship application is successful

1.  User requests to delete an internship application and provides the index.
2.  InternHunter removes the internship application from the list of internship applications. <br />
    Use case ends.

#### Extensions

1a. InternHunter detects an invalid input. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

1b. InternHunter detects an error in the input format. <br />
  1b1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

### Use case: UC07 - View an internship application

#### MSS

Precondition: User already has an existing list of internship applications <br />
Guarantees: Viewing of internship application is successful

1.  User requests to view the details of an internship application.
2.  InternHunter shows the details of this internship application. <br />
    Use case ends.

#### Extensions

1a. InternHunter detects an invalid input. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.
  
1b. InternHunter detects an error in the input format. <br />
  1b1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

### Use case: UC08 - Edit an internship application

#### MSS

Precondition: User already has an existing list of internship applications <br />
Guarantees: Editing of internship application is successful

1.  User requests to edit the details of an internship application and inputs the index and details.
2.  InternHunter edits the details of this internship application and the list is updated accordingly. <br />
    Use case ends.

#### Extensions

1a. InternHunter detects an invalid input. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

### Use case: UC09 - Add user profile item

#### MSS

Precondition: User is on the Profile page
Guarantees: Addition of user profile item is successful

1.  User requests to add a user profile item to the user profile and provides details.
2.  InternHunter adds the user profile item to the user profile. <br />
    Use case ends.

#### Extensions

 1a. InternHunter detects an invalid input. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

### Use case: UC10 - Delete a user profile item 

#### MSS

Precondition: User is on the Profile page and already has an existing list of user profile items <br/>
Guarantees: Deletion of user profile item is successful

1.  User requests to delete a user profile item from the user profile.
2.  InternHunter removes the user profile item from the user profile. <br/>
    Use case ends.

#### Extensions

  1a. InternHunter detects an invalid input. <br />
   1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
   Use case resumes from step 1.
  
  1b. InternHunter detects an invalid index.<br />
   1b1. InternHunter displays an error message and informs the user that the index is out of bounds. <br />
   Use case resumes from step 1.

### Use case: UC11 - Edit a user profile item

#### MSS

Precondition: User is on the Profile page and already has an existing list of user profile items <br/>
Guarantees: Editing of user profile item is successful

1.  User requests to edit the details of a user profile item and provides details.
2.  InternHunter edits the user profile item in the user profile. <br/>
    Use case ends.

#### Extensions

 1a. InternHunter detects an invalid input. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

 1b. InternHunter detects an invalid index.<br />
  1b1. InternHunter displays an error message and informs the user that the index is out of bounds. <br />
  Use case resumes from step 1.

### Use case: UC12 - View a user profile item

#### MSS
Precondition: User is on the Profile page and already has an existing list of user profile items <br/>
Guarantees: Viewing of user profile item is successful

1.  User requests to view the details of a user profile item.
2.  InternHunter shows the details of this internship application. <br/>
    Use case ends.
    
#### Extensions

 1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.

### Use case: UC13 - Switch tabs

#### MSS

1.  User requests to switch the tab of the screen.
2.  InternHunter switches to the requested tab. <br/>
    Use case ends.

#### Extensions

 1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.

### Use case: UC14 - Get help

#### MSS
Guarantees: User will get directions to the user guide

1.  User requests for help.
2.  InternHunter displays help message directing user to user guide. <br/>
    Use case ends.


### Use case: UC15 - Exit 

#### MSS

1.  User requests to exit InternHunter.
2.  InternHunter prompts for confirmation.
3.  User confirms intention to exit.
4.  InternHunter exits. <br/>
    Use case ends.

#### Extensions
 2a. User chooses to cancel the confirmation. <br/>
 Use case ends.
    
## Appendix D: Non-Functional Requirements

* Should be for a single user i.e. (not a multi-user product).
* The data should be stored locally and should be in a human editable text file.
* The software should work without requiring an installer.
* Should work on any mainstream OS as long as it has Java 11 or above installed.
* Should work on both 32-bit and 64-bit environment.
* Should only use third-party frameworks or libraries which are free, open-source and have permissive license term and 
do not require installation by user of the software.
* A user with above average typing speed for regular English text should be able to accomplish most of the tasks faster 
using commands than using the mouse.
* Should be a result of evolving and morphing the given code base.
* Should be developed in a breadth-first incremental manner over the project duration.

## Appendix E: Glossary

* **OS**: Operating System
* **Mainstream OS**: Windows, Linux, Unix, OS-X

--------------------------------------------------------------------------------------------------------------------
