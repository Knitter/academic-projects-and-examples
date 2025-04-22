unit Options;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TOptionsForm = class(TForm)
    GroupBox1: TGroupBox;
    GroupBox2: TGroupBox;
    edtServer: TEdit;
    edtSchema: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    chkSaveAppPos: TCheckBox;
    chkSaveAppSize: TCheckBox;
    chkAuthentication: TCheckBox;
    lblUsername: TLabel;
    lblPassword: TLabel;
    edtUsername: TEdit;
    edtPassword: TEdit;
    btnCancel: TButton;
    btnSave: TButton;
    procedure chkAuthenticationClick(Sender: TObject);
    procedure btnCancelClick(Sender: TObject);
    procedure btnSaveClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  OptionsForm: TOptionsForm;

implementation

{$R *.dfm}

uses
  IniFiles, MainForm;

procedure TOptionsForm.btnCancelClick(Sender: TObject);
begin
  Close;
end;

procedure TOptionsForm.btnSaveClick(Sender: TObject);
var
  ini: TIniFile;
begin
  ini := TIniFile.Create(ChangeFileExt(Application.ExeName, '.ini'));
  try
    ini.WriteBool('Options', 'saveposition', chkSaveAppPos.Checked);
    ini.WriteBool('Options', 'savesize', chkSaveAppSize.Checked);
    ini.WriteString('Options', 'server', edtServer.Text);
    ini.WriteString('Options', 'database', edtSchema.Text);
    ini.WriteBool('Options', 'usent', chkAuthentication.Checked);
  finally
    ini.Free;
  end;
  THotelGest(Owner).OptionsFileChanged;
  Close;
end;

procedure TOptionsForm.chkAuthenticationClick(Sender: TObject);
begin
  lblUsername.Enabled := not chkAuthentication.Checked;
  lblPassword.Enabled := not chkAuthentication.Checked;
  edtUsername.Enabled := not chkAuthentication.Checked;
  edtPassword.Enabled := not chkAuthentication.Checked;
end;

procedure TOptionsForm.FormCreate(Sender: TObject);
var
  ini: TIniFile;
begin
  ini := TIniFile.Create(ChangeFileExt(Application.ExeName, '.ini'));
  try
    chkSaveAppPos.Checked := ini.ReadBool('Options', 'saveposition', False);
    chkSaveAppSize.Checked := ini.ReadBool('Options', 'savesize', False);
    edtServer.Text := ini.ReadString('Options', 'server', 'localhost');
    edtSchema.Text := ini.ReadString('Options', 'database', 'HOTELGEST');
    chkAuthentication.Checked := ini.ReadBool('Options', 'usent', True);
  finally
    ini.Free;
  end;
end;

end.
