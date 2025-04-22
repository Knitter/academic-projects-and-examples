unit Room;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Data, ExtCtrls, DBCtrls, Grids, DBGrids, StdCtrls, ComCtrls, DB;

type
  TRoomForm = class(TForm)
    BTNClose: TButton;
    PageControl1: TPageControl;
    TabSheet1: TTabSheet;
    TabSheet2: TTabSheet;
    GroupBox1: TGroupBox;
    DBGRoom: TDBGrid;
    DBNavRoom: TDBNavigator;
    GroupBox2: TGroupBox;
    TabSheet3: TTabSheet;
    GroupBox3: TGroupBox;
    DBGRoomType: TDBGrid;
    DBNavRoomType: TDBNavigator;
    DBGOrientation: TDBGrid;
    DBNavOrientation: TDBNavigator;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure BTNCloseClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  RoomForm: TRoomForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TRoomForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TRoomForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  //HotelGestDataModule.ADODataSetOrientation.Active := False;
  //HotelGestDataModule.ADODataSetRoom.Active := False;
  //HotelGestDataModule.ADODataSetRoomType.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TRoomForm.FormCreate(Sender: TObject);
begin
  //HotelGestDataModule.ADODataSetOrientation.Active := True;
  //HotelGestDataModule.ADODataSetRoom.Active := True;
  //HotelGestDataModule.ADODataSetRoomType.Active := True;
end;

end.
