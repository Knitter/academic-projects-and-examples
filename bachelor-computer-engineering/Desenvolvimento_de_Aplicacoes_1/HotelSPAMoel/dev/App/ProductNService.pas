unit ProductNService;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Data, StdCtrls, Grids, DBGrids, ExtCtrls, DBCtrls, ComCtrls, DB;

type
  TProductNServiceForm = class(TForm)
    PageControl1: TPageControl;
    TabSheet1: TTabSheet;
    TabSheet2: TTabSheet;
    GroupBox1: TGroupBox;
    DBGrid1: TDBGrid;
    DBNavProducts: TDBNavigator;
    BTNClose: TButton;
    GroupBox2: TGroupBox;
    DBGrid2: TDBGrid;
    DBNavigator1: TDBNavigator;
    TabSheet3: TTabSheet;
    GroupBox3: TGroupBox;
    DBGrid3: TDBGrid;
    DBNavigator2: TDBNavigator;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure FormCreate(Sender: TObject);
    procedure BTNCloseClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  ProductNServiceForm: TProductNServiceForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TProductNServiceForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TProductNServiceForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  //HotelGestDataModule.ADODataSetCategory.Active := False;
  //HotelGestDataModule.ADODataSetServices.Active := False;
//  HotelGestDataModule.ADODataSetProducts.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TProductNServiceForm.FormCreate(Sender: TObject);
begin
  //HotelGestDataModule.ADODataSetCategory.Active := True;
  //HotelGestDataModule.ADODataSetServices.Active := True;
  //HotelGestDataModule.ADODataSetProducts.Active := False;
end;

end.
