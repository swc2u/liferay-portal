create table cscl_Appointment_Admin (
	uuid_ VARCHAR(75) null,
	ID LONG not null primary key,
	appointeeId LONG,
	appointee VARCHAR(75) null,
	appointedDate VARCHAR(75) null,
	FromTime VARCHAR(75) null,
	ToTime VARCHAR(75) null,
	SecondTimeSlot VARCHAR(75) null,
	ThirdTimeSlot VARCHAR(75) null,
	FourthTimeSlot VARCHAR(75) null,
	FifthTimeSlot VARCHAR(75) null,
	SixthTimeSlot VARCHAR(75) null,
	SeventhTimeSlot VARCHAR(75) null,
	EighthTimeSlot VARCHAR(75) null,
	NineTimeSlot VARCHAR(75) null,
	TenTimeSlot VARCHAR(75) null
);