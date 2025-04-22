unit Extra;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Data, StdCtrls, Buttons, DB, ExtCtrls, DBCtrls, Grids, DBGrids;

type
  TExtraForm = class(TForm)
    GroupBox1: TGroupBox;
    DBGTax: TDBGrid;
    DBNav: TDBNavigator;
    BTNClose: TBitBtn;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormCreate(Sender: TObject);
    procedure BTNCloseClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  ExtraForm: TExtraForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TExtraForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TExtraForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  HotelGestDataModule.ADODataSetExtra.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TExtraForm.FormCreate(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetExtra.Active := True;
end;

end.
