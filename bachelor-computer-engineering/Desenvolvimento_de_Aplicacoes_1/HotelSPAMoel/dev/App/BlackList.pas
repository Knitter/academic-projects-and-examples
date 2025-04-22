unit BlackList;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Data, ExtCtrls, StdCtrls, Grids, DBGrids, DBCtrls, DB;

type
  TBlackListForm = class(TForm)
    GroupBox1: TGroupBox;
    DBGBlacklist: TDBGrid;
    DBNav: TDBNavigator;
    Button2: TButton;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormCreate(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure BTNSeeAllClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  BlackListForm: TBlackListForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TBlackListForm.BTNSeeAllClick(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetBlacklist.Filtered := False;
end;

procedure TBlackListForm.Button2Click(Sender: TObject);
begin
  Close;
end;

procedure TBlackListForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  HotelGestDataModule.ADODataSetBlacklist.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TBlackListForm.FormCreate(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetBlacklist.Active := True
end;

end.
