unit Data;

interface

uses
  SysUtils, Classes, DB, ADODB, Dialogs;

type
  THotelGestDataModule = class(TDataModule)
    Conn: TADOConnection;
    ADODataSetTax: TADODataSet;
    ADODataSetProducts: TADODataSet;
    ADODataSetEmployee: TADODataSet;
    ADODataSetRegistered: TADODataSet;
    ADODataSetExtra: TADODataSet;
    ADODataSetDiscount: TADODataSet;
    ADODataSetClientList: TADODataSet;
    ADODataSetBlacklist: TADODataSet;
    ADODataSetCategory: TADODataSet;
    ADODataSetOrientation: TADODataSet;
    ADODataSetRoom: TADODataSet;
    ADODataSetServices: TADODataSet;
    ADODataSetRoomType: TADODataSet;
    DSTax: TDataSource;
    DSExtra: TDataSource;
    DSEmployee: TDataSource;
    DSDiscount: TDataSource;
    DSClientList: TDataSource;
    DSBlacklist: TDataSource;
    DSRegistered: TDataSource;
    DSService: TDataSource;
    DSCategories: TDataSource;
    DSProducts: TDataSource;
    DSOrientation: TDataSource;
    DSRoomType: TDataSource;
    DSRoom: TDataSource;
    ADODataSetRoomid: TAutoIncField;
    ADODataSetRoomidentification: TStringField;
    ADODataSetRoomorientation_id: TIntegerField;
    ADODataSetRoomtp_id: TIntegerField;
    ADODataSetRoomTypeName: TStringField;
    ADODataSetRoomOriName: TStringField;
    ADODataSetProductsid: TAutoIncField;
    ADODataSetProductsfd_name: TWideStringField;
    ADODataSetProductsmin_stock: TIntegerField;
    ADODataSetProductsstock: TIntegerField;
    ADODataSetProductsprice: TBCDField;
    ADODataSetProductscategory_id: TIntegerField;
    ADODataSetProductsCatName: TStringField;
    DSLogType: TDataSource;
    ADODataSetLogType: TADODataSet;
    ADODataSetLog: TADODataSet;
    DSLog: TDataSource;
    ADODataSetBlacklistid: TAutoIncField;
    ADODataSetBlacklistreservation_id: TIntegerField;
    ADODataSetBlacklistclient_id: TIntegerField;
    ADODataSetBlacklistentry_date: TStringField;
    ADODataSetBlacklistClientName: TStringField;
    ADODataSetLogTypeid: TAutoIncField;
    ADODataSetLogTypetp_name: TWideStringField;
    ADOQueryAuthenticate: TADOQuery;
    ADODataSetReservation: TADODataSet;
    ADODataSetSale: TADODataSet;
    DSSale: TDataSource;
    ADODataSetSaleid: TAutoIncField;
    ADODataSetSalesale_date: TStringField;
    ADODataSetSaleprice: TBCDField;
    ADODataSetSalepayed: TBCDField;
    ADODataSetSaleemployee_id: TIntegerField;
    ADODataSetSaleclient_id: TIntegerField;
    ADODataSetSaleClientName: TStringField;
    ADODataSetSaleEmployeeUser: TStringField;
    ADODataSetReservationid: TAutoIncField;
    ADODataSetReservationclient_id: TIntegerField;
    ADODataSetReservationemployee_id: TIntegerField;
    ADODataSetReservationregistered_id: TIntegerField;
    ADODataSetReservationreservation_date: TStringField;
    ADODataSetReservationdestination_date: TStringField;
    ADODataSetReservationsecond_choise: TStringField;
    ADOCommandDeleteLog: TADOCommand;
    ADOQueryGeneric: TADOQuery;
    ADODataSetCheckout: TADODataSet;
    DSCheckout: TDataSource;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  HotelGestDataModule: THotelGestDataModule;

implementation

{$R *.dfm}

end.
