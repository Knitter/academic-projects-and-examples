program HotelSPA;

{%File 'ligacao.udl'}

uses
  Forms,
  MainForm in 'MainForm.pas' {HotelGest},
  About in 'About.pas' {AboutForm},
  Employee in 'Employee.pas' {EmployeeForm},
  Data in 'Data.pas' {HotelGestDataModule: TDataModule},
  Login in 'Login.pas' {LoginForm},
  LogViewer in 'LogViewer.pas' {LogViewerForm},
  Tax in 'Tax.pas' {TaxForm},
  BlackList in 'BlackList.pas' {BlackListForm},
  Options in 'Options.pas' {OptionsForm},
  ClientList in 'ClientList.pas' {ClientListForm},
  Registered in 'Registered.pas' {RegisteredForm},
  Room in 'Room.pas' {RoomForm},
  ProductNService in 'ProductNService.pas' {ProductNServiceForm},
  Reservation in 'Reservation.pas' {ReservationForm},
  Booking in 'Booking.pas' {BookingForm},
  Discount in 'Discount.pas' {DiscountForm},
  Extra in 'Extra.pas' {ExtraForm},
  Sales in 'Sales.pas' {SalesForm},
  RecoverPassword in 'RecoverPassword.pas' {RecoverPasswordForm},
  CheckOut in 'CheckOut.pas' {CheckOutForm};

{$R *.res}

begin
  Application.Initialize;
  Application.Title := 'HotelGest';
  Application.CreateForm(THotelGest, HotelGest);
  Application.CreateForm(THotelGestDataModule, HotelGestDataModule);
  Application.Run;
end.
