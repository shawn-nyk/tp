---
layout: page
title: User Guide
---

### Switching Tabs : `switch`

Switches between tabs.

Format: `switch -TYPE`

There are three types:
* `com`
* `int`
* `me`

Example: 
* `switch -me`

### Viewing Help : `help`
Displays a link to the InternHunter user guide.

Format: `help`

### Exiting the Program : `exit`
Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## Command summary

Type            | Action     | Format
----------------|------------|------------------
**Company**     | **Add**    | `add -com n/COMPANY_NAME i/INDUSTRY j/JOBS`
&nbsp;          | **Delete** | `delete -com INDEX`
&nbsp;          | **Edit**   | `edit -com INDEX [n/COMPANY_NAME] [i/INDUSTRY] [j/JOBS]`
&nbsp;          | **View**   | `view -com INDEX`
**Internship**  | **Add**    | `add -int n/COMPANY_NAME j/JOB_NAME  [i/INDUSTRY] [r/REQUIREMENT] [p/PERIOD] [w/WAGE]` <br/> `add -int  n/COMPANY_NAME INDEX`
&nbsp;          | **Delete** | `delete -int INDEX`
&nbsp;          | **Edit**   | `edit -int INDEX [n/COMPANY_NAME] [j/JOB_NAME] [i/INDUSTRY] [r/REQUIREMENT] [p/PERIOD] [w/WAGE] [s/STATUS] [d/DATE]`
&nbsp;          | **View**   | `view -int INDEX`
**Profile**     | **Add**    | `add -me  c/CAT d/DESCRIPTORS`
&nbsp;          | **Delete** | `delete -me INDEX`
&nbsp;          | **Edit**   | `edit -me INDEX [c/CAT] [d/DESCRIPTORS]`
&nbsp;          | **View**   | `view -me INDEX`
**General**     | **Switch** | `switch -TYPE`
&nbsp;          | **Help**   | `help`
&nbsp;          | **Exit**   | `exit`
