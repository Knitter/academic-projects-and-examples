DROP TABLE trace;
DROP TABLE meteo_data;

CREATE TABLE meteo_data(
xml_date VARCHAR(50),
data_value VARCHAR(50),
data_type VARCHAR(30),
CONSTRAINT pk_meteo_data_date_value PRIMARY KEY (xml_date, data_type)
)

CREATE TABLE trace(
xml_date VARCHAR(50),
data_type VARCHAR(30),
node VARCHAR(200),
CONSTRAINT pk_trace_date_value PRIMARY KEY (xml_date, data_type),
CONSTRAINT fk_trace_message_id FOREIGN KEY (xml_date, data_type) REFERENCES meteo_data(xml_date, data_type)
)