---
layout: page
title: User Guide
---

--------------------------------------------------------------------------------------------------------------------

## Features

### Internship Application

#### Adding an internship application: `add-int`

Applies for an internship. This internship will be automatically added to the list of jobs in the company
(if company has already been created). Otherwise, it creates the company and adds this job into it.

Format: `add -int n/COMPANY_NAME j/JOB_NAME [i/INDUSTRY] [p/PERIOD] [w/WAGE] [r/REQUIREMENT]...`

Examples:
- add -int n/Google i/Software j/Software Engineer
- add -int n/Google i/Software j/Software Engineer r/React w/3000 r/HTML5

**Already created the internship before?**

Fret not, we have an alternative method to apply for an internship! This format adds an internship with the company
name and job name only.

Format: `add -int n/COMPANY_NAME INDEX` - `INDEX` refers to position of internship in the company

_Note: `view -com INDEX` (to view a company's profile, including its list of jobs)_

#### Deleting an internship application: `delete -int`

Deletes an internship.
 
Format: `delete -int INDEX` - `INDEX` is the index of the internship application in the list of internship
applications

Examples:
- `delete -int 3`

#### Editing an internship application: `edit -int`

Edits an internship.

Format:  `edit -int INDEX [n/COMPANY_NAME] [j/JOB_NAME] [i/INDUSTRY] [p/PERIOD] [w/WAGE] [s/STATUS] [d/DATE] 
[r/REQUIREMENT]...` - `INDEX` is the index of the internship application in the list of internship applications.

_Note that DATE can only be added if there is a STATUS in the input._

Examples:
- `edit -int 7 r/Java r/FXML w/2000`
- `edit -int 4 s/interview d/22-09-20`

##### More about internships…

Each job has its own status. On initial adding of internship, the status of the internship application is applied by
default. Each status will be tagged to a date. If a date is not specified, InternHunter will assign today’s date to it.

Accepted statuses:
- Applied
- Interview
- Waiting
- Rejected
- Accepted

Accepted date formats:

- d-M-yy HHmm
    - e.g. 23-12-19 2230
- d-M-yy
    - e.g. 23-12-19
    - Time will be taken as 2359

#### Viewing an internship application: `view -int`

Selects an internship application in the list of internship applications to show in detail.
 
Format: `view -int INDEX` - `INDEX` is the index of the internship application in the list of internship
applications

Examples:
- `view -int 3`
