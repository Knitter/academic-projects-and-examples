unit About;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ComCtrls, ExtCtrls, StdCtrls, jpeg;

type
  TAboutForm = class(TForm)
    btnOK: TButton;
    Tabs: TPageControl;
    LogoPage: TTabSheet;
    Logo: TImage;
    LicensePage: TTabSheet;
    Label1: TLabel;
    MMLicense: TMemo;
    procedure btnOKClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  AboutForm: TAboutForm;

implementation

{$R *.dfm}

procedure TAboutForm.btnOKClick(Sender: TObject);
begin
  Close;
end;

procedure TAboutForm.FormCreate(Sender: TObject);
begin
  try
    MMLicense.Lines.LoadFromFile('Licence.txt');
  Except
    MMLicense.Lines.Clear;
    MMLicense.Lines.Add('Ficheiro de Licença não encontrado.') 
  end;
end;

end.
