SpringBoot Postgresql BD based App.

This is a simple app which creates unique ids and returns (Even in clusterd environments).
Approx 7.959 * 10 raise to 24. (Max Value 7,958,661,109,946,399,999)
returned as Base36 with 16 digits
Base36 uses:
Digits: 0-9 (values 0-9)
Letters: A-Z (values 10-35)

sample data for get request.
GET /api/next-tracking-number?originCountryId=MY&destinationCountryId=ID&weight=1.234&createdAt=2023-10-10T12:00:00Z&customerId=de619854-b59b-425e-9db4-943979e1bd49&customerName=RedBox%20Logistics&customerSlug=redbox-logistics

It also validates the input data. 

The unique sequence number is taken from the sequence below
CREATE SEQUENCE tracking_id_gen_seq START 100000;

