unit Login;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Mask, StdCtrls;

type
  TLoginForm = class(TForm)
    lblUsername: TLabel;
    edtUsername: TEdit;
    lblPassword: TLabel;
    btnOK: TButton;
    mskPassword: TMaskEdit;
    procedure btnOKClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  LoginForm: TLoginForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TLoginForm.btnOKClick(Sender: TObject);
begin
  THotelGest(Owner).AcceptLoginData(edtUsername.Text, mskPassword.Text);
  Close;
end;

end.
