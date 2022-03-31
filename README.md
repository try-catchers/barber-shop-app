# Barber Shop Appointments

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

### App Evaluation

- **Category:** Store Application/Appointment Scheduler
- **Mobile:** This is an application developed in mobile for convenience of recurring customers that have a preference for one stylist within the barber shop. Being a mobile application lets users to interact with it on-the-go as it is the most handy device for an action such as scheduling
- **Story:** Creates, manages, and notifies users within this app for appointments in a barber shop. On the other side, stylists are also notified for when their next appointment is active and will be instantly notified of any reschedules or cancellations.
- **Market:** Customers that have a preference for a stylist within the barber shop franchise. However, this application has potential for barber shops to create their own dashboard for stylists' convenience.
- **Habit:** This app would be very handy for customers and stylists to have direct contact with both parties and be instantly notified for updates. It also minimizes the time lost for stylists waiting for customers that rescheduled or cancelled.   
- **Scope:** First, this will be an application that will be based on one barber shop, then evolve it into a barber shop franchise, and then move on to make a platform for any business that would like to have direct contact with customers that like to make appointments with an agent of their preference. 

## Overview
### Description
This is an application in order to provide convenience for customers at the time of having to schedule a new appointment without having time to call a barber shop but to schedule during off-work hours with their favourite barber 

### App Evaluation
- **Category:** Store application/Scheduling application
- **Mobile:** Application allows user to create appointments within the different locations of the barber shop franchise
- **Story:** This application allows customers have more convenience at the time of doing appointments with detailed information where their stylist of preference is busy or not 
- **Market:** Anyone that is not able to call during work hours or needs to schedule their time ahead in order to obtain a haircut or any service related with styling
- **Habit:** Users can appoint and see available times at any time no matter if the physical shop is closed or not. 
- **Scope:** This application has the scope of filling the barber shop appointment times in order to attract more customers by incentivizing them to use a sofisticated appointment application for their convenience and time

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User can login
* User can create a new account
* User can create a new scheduled appointment (only one active appointment per user)
* In the new appointment page, the user can select a barber to have an appointment with
* User will be alerted for the upcoming 
* Stylists can login
* Stylists will be alerted when new appointments are created
* Stylists will be alerted at the time of the appointment

**Optional Nice-to-have Stories**

* Integration with Google or other social media platform in order to register
* Stylists can erase appointments with customers with a message (this message will appear as a notification to the customer that created the appointment)
* Navigation bar implementation
* Before selecting a barber in the new appointment page, the user can select one of the locations within the franchise

### 2. Screen Archetypes

* Login Screen
   * User/Stylist can login
   * User can register
* Menu Screen
   * User can go to new appointment
   * User can go to cancel appointment
* New appointment screen
   * User can select a barber
   * User can select the time(if available)
* Menu screen(stylist user)
   * Stylist can see appointed times within the current day

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Overview
* New Appointment
* Current appointment

**Flow Navigation** (Screen to Screen)

* Login Screen

   -> Overview
* Registration Screen

   -> Overview
* New Appointment Screen

   -> Select barber

   -> Select time

   -> Current Appointment (after new appointment is completed)

* Current Appointment

   -> None

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="YOUR_WIREFRAME_IMAGE_URL" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
