unit Employee;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Data, StdCtrls, Grids, DBGrids, Mask, ComCtrls, ExtCtrls, DBCtrls,
  Buttons, DB, RecoverPassword;

type
  TEmployeeForm = class(TForm)
    GroupBox3: TGroupBox;
    DBGrid1: TDBGrid;
    DBNavigator1: TDBNavigator;
    GroupBox1: TGroupBox;
    EDTName: TEdit;
    EDTSurname: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    Label5: TLabel;
    Label6: TLabel;
    Label7: TLabel;
    CHKAdmin: TCheckBox;
    EDTMail: TEdit;
    BITBTNInsert: TBitBtn;
    GroupBox2: TGroupBox;
    Label8: TLabel;
    EDTUsername: TEdit;
    Label9: TLabel;
    EDTPassword: TEdit;
    BTNResetPassword: TButton;
    DTOBirthDate: TDateTimePicker;
    Label10: TLabel;
    Label11: TLabel;
    EDTID: TEdit;
    EDTRegistrationNr: TEdit;
    EDTPhone: TEdit;
    EDTCellphone: TEdit;
    EDTIban: TEdit;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure btnCloseClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
    procedure BITBTNInsertClick(Sender: TObject);
    procedure BTNResetPasswordClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  EmployeeForm: TEmployeeForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TEmployeeForm.BITBTNInsertClick(Sender: TObject);
begin
  try
    if HotelGestDataModule.ADODataSetEmployee.State = dsInactive then
    begin
      HotelGestDataModule.ADODataSetEmployee.Open;
    end;

    if HotelGestDataModule.ADODataSetEmployee.State = dsBrowse then
    begin
      HotelGestDataModule.ADODataSetEmployee.Insert;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('first_name').Value := EDTName.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('surname').Value := EDTSurname.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('registration_number').Value := EDTRegistrationNr.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('phone').Value := EDTPhone.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('cellphone').Value := EDTCellphone.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('email').Value := EDTMail.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('id_number').Value := EDTID.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('iban').Value := EDTIban.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('birth_date').Value := DateToStr(DTOBirthDate.Date);
      HotelGestDataModule.ADODataSetEmployee.FieldByName('emp_username').Value := EDTUsername.Text;
      HotelGestDataModule.ADODataSetEmployee.FieldByName('emp_password').Value := EDTPassword.Text;
      if CHKAdmin.Checked  then
        HotelGestDataModule.ADODataSetEmployee.FieldByName('emp_type').Value := 'A';
      HotelGestDataModule.ADODataSetEmployee.Post;
    end;
  Except
  //do nothing!
  end;
end;

procedure TEmployeeForm.btnCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TEmployeeForm.BTNResetPasswordClick(Sender: TObject);
var
  recover: TRecoverPasswordForm;
begin
  recover := TRecoverPasswordForm.Create(Self);
  recover.ShowModal;
end;

procedure TEmployeeForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  HotelGestDataModule.ADODataSetEmployee.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TEmployeeForm.FormCreate(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetEmployee.Active := True;
end;

end.
