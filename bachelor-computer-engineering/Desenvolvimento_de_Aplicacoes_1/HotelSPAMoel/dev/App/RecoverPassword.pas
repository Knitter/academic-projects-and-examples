unit RecoverPassword;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, Data;

type
  TRecoverPasswordForm = class(TForm)
    GroupBox2: TGroupBox;
    Label2: TLabel;
    EDTRepeatPassword: TEdit;
    Label3: TLabel;
    BTNCancel: TButton;
    BTNRecover: TButton;
    EDTNewPassword: TEdit;
    procedure BTNCancelClick(Sender: TObject);
    procedure BTNRecoverClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  RecoverPasswordForm: TRecoverPasswordForm;

implementation

{$R *.dfm}
uses
  Employee;

procedure TRecoverPasswordForm.BTNCancelClick(Sender: TObject);
begin
  Close;
end;

procedure TRecoverPasswordForm.BTNRecoverClick(Sender: TObject);
begin
  if EDTNewPassword.Text = EDTRepeatPassword.Text then
    HotelGestDataModule.ADODataSetEmployee.FieldByName('emp_password').Value := EDTNewPassword.Text;
end;

end.
