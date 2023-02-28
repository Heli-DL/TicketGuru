# TicketGuru REST API

## Base URL
https://ticketguru.com

## EventRecord

### List All Events

**URL:** `/events`

**Method:** `GET`

**Auth required:** NO (needs to be fixed)

**Permissions required:** NO

#### Success Response

**Code** : `200 OK`

**Content examples**

```
[
    {
        "eventrecord_id": 1,
        "eventrecord_name": "Tapahtuma 1",
        "event_starttime": "2023-02-02T19:00:00",
        "event_endtime": "2023-02-02T23:30:00",
        "deleted": false
    },
    {
        "eventrecord_id": 2,
        "eventrecord_name": "Tapahtuma 2",
        "event_starttime": "2023-03-03T16:00:00",
        "event_endtime": "2023-03-03T19:30:00",
        "deleted": false
    },
    {
        "eventrecord_id": 3,
        "eventrecord_name": "Tapahtuma 3",
        "event_starttime": "2023-04-04T00:00:00",
        "event_endtime": "2023-04-05T23:55:00",
        "deleted": false
    }
]
```

### Find By Id

**URL:** `/events/{id}`

**Method:** `GET`

**Auth required:** NO (needs to be fixed)

**Permissions required:** NO

#### Success Response

**Condition**: If everything is OK and eventrecord_id is found

**Code** : `200 OK`

**Content examples**

/events/1

```
{
    "eventrecord_id": 1,
    "eventrecord_name": "Tapahtuma 1",
    "event_starttime": "2023-02-02T19:00:00",
    "event_endtime": "2023-02-02T23:30:00",
    "deleted": false
}
```
### Add new event

**URL:** `/events`

**Method:** `POST`

**Auth required:** NO (needs to be fixed)

**Permissions required:** NO

#### Success Response

**Condition**: If everything is OK

**Code** : `201 Created`

**Content examples**
```
{
    "eventrecord_id": 4,
    "eventrecord_name": "Tapahtuma 4 ",
    "event_starttime": "2023-02-02T19:00:00",
    "event_endtime": "2023-02-02T23:30:00",
    "deleted": false
}
```
### Update event

**URL:** `/events/{id}`

**Method:** `DELETE`

**Auth required:** NO (needs to be fixed)

**Permissions required:** NO

#### Success Response

**Code** : `200 OK`

**Content examples**

Response show updated name for event with id 4
```
{
    "eventrecord_id": 4,
    "eventrecord_name": "Konsertti",
    "event_starttime": "2023-02-02T19:00:00",
    "event_endtime": "2023-02-02T23:30:00",
    "deleted": false
}
```

### Delete By Id

**URL:** `/events/{id}`

**Method:** `DELETE`

**Auth required:** NO (needs to be fixed)

**Permissions required:** NO

#### Success Response

**Code** : `200 OK`

**Content examples**

 ```
 Event with id 4 was successfully deleted
 ```

## Ticket


## TicketType


## SalesEvent


## AppUser


## UserRole
