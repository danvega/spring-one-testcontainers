alter table message
    add column date_of_expiration date;

-- In PostgreSQL the interval data type is used to store and manipulate a time period.
update message
set date_of_expiration = current_date + interval '1 month';