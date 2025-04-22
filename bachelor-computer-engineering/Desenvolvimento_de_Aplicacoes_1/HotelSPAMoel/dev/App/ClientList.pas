unit ClientList;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, ExtCtrls, DBCtrls, Grids, DBGrids, Data, DB;

type
  TClientListForm = class(TForm)
    GroupBox1: TGroupBox;
    EDTNameSearch: TEdit;
    Label1: TLabel;
    BTNSearch: TButton;
    GroupBox2: TGroupBox;
    DBGClientList: TDBGrid;
    DBNav: TDBNavigator;
    BTNClose: TButton;
    Label2: TLabel;
    EDTNumberSearch: TEdit;
    BTNSeeAll: TButton;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure BTNCloseClick(Sender: TObject);
    procedure BTNSearchClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
    procedure BTNSeeAllClick(Sender: TObject);
    procedure EDTNameSearchEnter(Sender: TObject);
    procedure EDTNumberSearchEnter(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  ClientListForm: TClientListForm;

implementation

{$R *.dfm}
uses
  MainForm;

procedure TClientListForm.BTNCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TClientListForm.BTNSearchClick(Sender: TObject);
var
  filter : String;
begin
  if not (EDTNameSearch.Text = '') then
  begin
    filter := 'client_name LIKE ' + QuotedStr('*' + EDTNameSearch.Text + '*');
    HotelGestDataModule.ADODataSetClientList.Filter := filter;
    HotelGestDataModule.ADODataSetClientList.Filtered := True;
  end
  else
    if not (EDTNumberSearch.Text = '') then
    begin
      filter := 'registration_number = ' + QuotedStr(EDTNumberSearch.Text);
      HotelGestDataModule.ADODataSetClientList.Filter := filter;
      HotelGestDataModule.ADODataSetClientList.Filtered := True;
    end;
end;

procedure TClientListForm.BTNSeeAllClick(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetClientList.Filtered := False;
end;

procedure TClientListForm.EDTNameSearchEnter(Sender: TObject);
begin
  EDTNumberSearch.Clear;
end;

procedure TClientListForm.EDTNumberSearchEnter(Sender: TObject);
begin
  EDTNameSearch.Clear;
end;

procedure TClientListForm.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  HotelGestDataModule.ADODataSetClientList.Active := False;
  THotelGest(Owner).UpdateWindowMenuRemove(Tag);
  Action := caFree;
end;

procedure TClientListForm.FormCreate(Sender: TObject);
begin
  HotelGestDataModule.ADODataSetClientList.Active := True;
end;

end.
