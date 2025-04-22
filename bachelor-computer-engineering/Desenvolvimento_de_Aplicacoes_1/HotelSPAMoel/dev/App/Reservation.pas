unit Reservation;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, Mask, ComCtrls, Data, DB;

type
  TReservationForm = class(TForm)
    GroupBox1: TGroupBox;
    GroupBox2: TGroupBox;
    GroupBox3: TGroupBox;
    BTNClose: TButton;
    BTNCreate: TButton;
    Label6: TLabel;
    Label23: TLabel;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label9: TLabel;
    Label10: TLabel;
    Label11: TLabel;
    Label12: TLabel;
    Label15: TLabel;
    Label16: TLabel;
    Label17: TLabel;
    Label18: TLabel;
    CHKClientType: TCheckBox;
    EDTClientName: TEdit;
    MSKClientRegistrationNr: TMaskEdit;
    MSKClientPhone: TMaskEdit;
    MSKClienteCellphone: TMaskEdit;
    MSKClientFax: TMaskEdit;
    EDTClientMail: TEdit;
    EDTClientAddress: TEdit;
    EDTClientCity: TEdit;
    EDTClientPostal: TEdit;
    EDTClientCountry: TEdit;
    Label13: TLabel;
    Label14: TLabel;
    Label19: TLabel;
    EDTRegisteredSurname: TEdit;
    MSKRegisteredID: TMaskEdit;
    MSKRegisteredPhone: TMaskEdit;
    MSKRegisteredCellphone: TMaskEdit;
    EDTRegisteredMail: TEdit;
    GroupBox4: TGroupBox;
    BTNSearchClients: TButton;
    BTNSearchGuests: TButton;
    CHKSecondChoise: TCheckBox;
    Label4: TLabel;
    Label5: TLabel;
    DTPCheckIn: TDateTimePicker;
    DTPCheckOut: TDateTimePicker;
    EDTRegisteredName: TEdit;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure BTNCloseClick(Sender: TObject);
    procedure BTNCreateClick(Sender: TObject);
    procedure BTNSearchClientsClick(Sender: TObject);
    procedure BTNSearchGuestsClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  ReservationForm: TReservationForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TReservationForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TReservationForm.BTNCreateClick(Sender: TObject);
var
  clientid: Integer;
  registeredid: Integer;
begin
  clientid := -1;
  registeredid := -1;
  try
    if HotelGestDataModule.ADODataSetReservation.State = dsInactive then
      HotelGestDataModule.ADODataSetReservation.Open;

    if HotelGestDataModule.ADODataSetClientList.State = dsInactive then
      HotelGestDataModule.ADODataSetClientList.Open;

    if HotelGestDataModule.ADODataSetRegistered.State = dsInactive then
    begin
      HotelGestDataModule.ADODataSetRegistered.Insert;
      HotelGestDataModule.ADODataSetRegistered.FieldByName('first_name').Value := EDTRegisteredName.Text;
      HotelGestDataModule.ADODataSetRegistered.FieldByName('surname').Value := EDTRegisteredSurname.Text;
      HotelGestDataModule.ADODataSetRegistered.FieldByName('phone').Value := MSKRegisteredPhone.Text;
      HotelGestDataModule.ADODataSetRegistered.FieldByName('cellphone').Value := MSKRegisteredCellphone.Text;
      HotelGestDataModule.ADODataSetRegistered.FieldByName('email').Value := EDTRegisteredMail.Text;
      HotelGestDataModule.ADODataSetRegistered.FieldByName('id_number').Value := MSKRegisteredID.Text;
      HotelGestDataModule.ADODataSetRegistered.Post;
      HotelGestDataModule.ADOQueryGeneric.SQL.Clear;
      HotelGestDataModule.ADOQueryGeneric.SQL.Add('SELECT @@IDENTITY AS idvalue FROM tbl_registered');
      HotelGestDataModule.ADOQueryGeneric.Open;
      HotelGestDataModule.ADOQueryGeneric.First;
      registeredid := HotelGestDataModule.ADOQueryGeneric.FieldByName('idvalue').Value;
    end;

    if HotelGestDataModule.ADODataSetClientList.State = dsBrowse then
    begin
      HotelGestDataModule.ADODataSetClientList.Insert;
      HotelGestDataModule.ADODataSetClientList.FieldByName('client_name').Value := EDTClientName.Text;
      HotelGestDataModule.ADODataSetClientList.FieldByName('registration_number').Value := MSKClientRegistrationNr.Text;
      HotelGestDataModule.ADODataSetClientList.FieldByName('phone').Value := MSKClientPhone.Text;
      HotelGestDataModule.ADODataSetClientList.FieldByName('cellphone').Value := MSKClienteCellphone.Text;
      HotelGestDataModule.ADODataSetClientList.FieldByName('email').Value := EDTClientMail.Text;
      HotelGestDataModule.ADODataSetClientList.FieldByName('fax').Value := MSKClientFax.Text;

      if CHKClientType.Checked then
        HotelGestDataModule.ADODataSetClientList.FieldByName('client_type').Value := 'A';

      HotelGestDataModule.ADODataSetClientList.FieldByName('address').Value := EDTClientAddress.Text;
      HotelGestDataModule.ADODataSetClientList.FieldByName('city').Value := EDTClientCity.Text;
      HotelGestDataModule.ADODataSetClientList.FieldByName('zip_code').Value := EDTClientPostal.Text;
      HotelGestDataModule.ADODataSetClientList.FieldByName('country').Value := EDTClientCountry.Text;
      HotelGestDataModule.ADODataSetClientList.Post;
      HotelGestDataModule.ADOQueryGeneric.SQL.Clear;
      HotelGestDataModule.ADOQueryGeneric.SQL.Add('SELECT @@IDENTITY AS idvalue FROM tbl_client');
      HotelGestDataModule.ADOQueryGeneric.Open;
      HotelGestDataModule.ADOQueryGeneric.First;
      clientid := HotelGestDataModule.ADOQueryGeneric.FieldByName('idvalue').Value;
    end;

    if HotelGestDataModule.ADODataSetReservation.State = dsBrowse then
    begin
      HotelGestDataModule.ADODataSetReservation.Insert;
      HotelGestDataModule.ADODataSetReservation.FieldByName('reservation_date').Value := DateToStr(DTPCheckIn.Date);
      HotelGestDataModule.ADODataSetReservation.FieldByName('destination_date').Value := DateToStr(DTPCheckOut.Date);

      if CHKSecondChoise.Checked then
        HotelGestDataModule.ADODataSetReservation.FieldByName('second_choise').Value := 'Y';

      HotelGestDataModule.ADODataSetReservation.FieldByName('client_id').Value := clientid;
      HotelGestDataModule.ADODataSetReservation.FieldByName('employee_id').Value := HotelGest.Emp;
      HotelGestDataModule.ADODataSetReservation.FieldByName('registered_id').Value := registeredid;
      HotelGestDataModule.ADODataSetReservation.Post;
    end;
  Except
  //do nothing!
  end;
end;

procedure TReservationForm.BTNSearchClientsClick(Sender: TObject);
begin
//not implemented yet
end;

procedure TReservationForm.BTNSearchGuestsClick(Sender: TObject);
begin
//not implemented yet
end;

procedure TReservationForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

end.
