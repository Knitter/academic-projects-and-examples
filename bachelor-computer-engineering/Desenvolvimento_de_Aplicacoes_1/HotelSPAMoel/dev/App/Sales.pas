unit Sales;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Grids, DBGrids, StdCtrls, Data, ExtCtrls, DBCtrls;

type
  TSalesForm = class(TForm)
    GroupBox1: TGroupBox;
    BTNClose: TButton;
    DBGrid1: TDBGrid;
    DBNav: TDBNavigator;
    procedure BTNCloseClick(Sender: TObject);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  SalesForm: TSalesForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TSalesForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TSalesForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

end.
