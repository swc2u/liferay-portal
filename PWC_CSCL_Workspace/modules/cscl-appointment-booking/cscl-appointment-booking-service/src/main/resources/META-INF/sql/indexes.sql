create index IX_278266F0 on cscl_appointee_master (isActive);

create index IX_168CDFD5 on cscl_appointment_master (FromTime[$COLUMN_LENGTH:75$], ToTime[$COLUMN_LENGTH:75$]);
create index IX_92B04BE3 on cscl_appointment_master (appointee);
create index IX_CF1D78E7 on cscl_appointment_master (approver);
create index IX_B22923B3 on cscl_appointment_master (name[$COLUMN_LENGTH:75$], email[$COLUMN_LENGTH:75$], appointee, preferedDate, preferedTime[$COLUMN_LENGTH:75$]);
create index IX_B43C6F3D on cscl_appointment_master (status, appointee);

create index IX_A9CCB951 on cscl_approver_mapping (appointee);
create index IX_C84A6A5D on cscl_approver_mapping (assignedTo);

create index IX_98EB04C0 on cscl_approver_master (isActive);

create index IX_1A485222 on cscl_status (isActive);