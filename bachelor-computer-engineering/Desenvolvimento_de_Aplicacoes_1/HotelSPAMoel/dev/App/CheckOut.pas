unit CheckOut;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Data, ExtCtrls, DBCtrls, Grids, DBGrids, StdCtrls;

type
  TCheckOutForm = class(TForm)
    GroupBox1: TGroupBox;
    DBGrid1: TDBGrid;
    DBNavigator1: TDBNavigator;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  CheckOutForm: TCheckOutForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TCheckOutForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

end.
