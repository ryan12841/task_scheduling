# task_scheduling
📌 ProManage Solutions – Automated Project Scheduling System
📖 Overview

ProManage Solutions Pvt. Ltd. is a project management company handling multiple client software projects such as UI design, development, testing, and deployment. Each completed project generates revenue for the company.

To avoid missed deadlines and revenue loss caused by manual spreadsheet planning, this system automates project scheduling using a Java-based application connected to a PostgreSQL database.

The system selects and schedules projects optimally to maximize weekly profit while strictly following business rules.

🎯 Problem Statement

Projects are received by Saturday

Planning is done over the weekend

Work starts from Monday

The company operates Monday to Friday only

Maximum 5 projects per week

Only 1 project per day

Each project has:

Title

Deadline (in working days)

Expected Revenue

If a project is not completed before its deadline, the company loses the revenue.

Example:
If deadline = 3, the project must be completed within the first 3 working days (Monday–Wednesday).

🚀 Objective

Develop a system that:

Stores project details in PostgreSQL

Automatically generates unique project IDs

Allows managers to:

Add projects

View projects

Generate optimal weekly schedule

Maximizes total revenue

Ensures:

Maximum 5 projects per week

Only 1 project per day

Deadlines are strictly respected

🛠️ Technology Stack

Backend: Java

Database: PostgreSQL

JDBC: For database connectivity

Algorithm Used: Greedy Scheduling Algorithm (Job Sequencing with Deadlines)

🧠 Scheduling Logic

The system uses a Greedy Algorithm:

Sort projects in descending order of revenue

For each project:

Assign it to the latest available day before its deadline

Skip the project if:

No slot is available before its deadline

Weekly limit (5 projects) is reached

This ensures maximum revenue optimization.

📂 Database Design
Table: projects
Column Name	Data Type	Description
id	SERIAL (PK)	Auto-generated project ID
title	VARCHAR	Project title
deadline	INTEGER	Deadline in working days (1–5)
revenue	DOUBLE	Expected revenue
📋 Features

✔ Add new project
✔ View all projects
✔ Generate optimal weekly schedule
✔ Revenue maximization
✔ Automatic ID generation
✔ PostgreSQL integration
✔ Enforced business rules

🗓️ Weekly Schedule Constraints

Monday → Day 1

Tuesday → Day 2

Wednesday → Day 3

Thursday → Day 4

Friday → Day 5

Rules:

Maximum 5 projects per week

Only 1 project per day

A project with deadline d must be completed on or before day d

📊 Example
Input Projects:
Title	Deadline	Revenue
Project A	2	5000
Project B	1	7000
Project C	3	3000
Project D	2	6000
Optimized Output Schedule:
Day	Project	Revenue
Monday	Project B	7000
Tuesday	Project D	6000
Wednesday	Project C	3000

Total Revenue = 16000

⚙️ How to Run

Install PostgreSQL

Create database

Create projects table

Update DB credentials in Java code

Compile and run the application

📈 Benefits

Eliminates manual scheduling errors

Prevents missed deadlines

Maximizes company revenue

Improves planning efficiency

Scalable for future enhancements

🔮 Future Enhancements

Multi-week scheduling

Priority-based projects

Web-based dashboard

Admin & Manager login roles

Reporting & analytics module
