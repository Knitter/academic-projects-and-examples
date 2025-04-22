unit Tax;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, Grids, DBGrids, ExtCtrls, DBCtrls, Data, DB, Buttons;

type
  TTaxForm = class(TForm)
    BTNClose: TBitBtn;
    GroupBox1: TGroupBox;
    DBGTax: TDBGrid;
    DBNav: TDBNavigator;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormCreate(Sender: TObject);
    procedure BTNCloseClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  TaxForm: TTaxForm;

implementation

{$R *.dfm}

uses
  MainForm;

procedure TTaxForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TTaxForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  HotelGestDataModule.ADODataSetTax.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TTaxForm.FormCreate(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetTax.Active := True;
end;

end.
