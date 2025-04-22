unit Service;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs;

type
  TServiceForm = class(TForm)
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  ServiceForm: TServiceForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TServiceForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

end.
