object HotelGestDataModule: THotelGestDataModule
  OldCreateOrder = False
  Height = 560
  Width = 776
  object Conn: TADOConnection
    Connected = True
    ConnectionString = 'FILE NAME=.\ligacao.udl'
    LoginPrompt = False
    Provider = 'SQLNCLI.1'
    Left = 24
    Top = 13
  end
  object ADODataSetTax: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_tax'
    Parameters = <>
    Left = 558
    Top = 199
  end
  object ADODataSetProducts: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_food_drink'
    Parameters = <>
    Left = 306
    Top = 264
    object ADODataSetProductsid: TAutoIncField
      FieldName = 'id'
      ReadOnly = True
      Visible = False
    end
    object ADODataSetProductsfd_name: TWideStringField
      FieldName = 'fd_name'
      FixedChar = True
      Size = 50
    end
    object ADODataSetProductsmin_stock: TIntegerField
      FieldName = 'min_stock'
    end
    object ADODataSetProductsstock: TIntegerField
      FieldName = 'stock'
    end
    object ADODataSetProductsprice: TBCDField
      FieldName = 'price'
      Precision = 10
    end
    object ADODataSetProductscategory_id: TIntegerField
      FieldName = 'category_id'
      Visible = False
    end
    object ADODataSetProductsCatName: TStringField
      FieldKind = fkLookup
      FieldName = 'CatName'
      LookupDataSet = ADODataSetCategory
      LookupKeyFields = 'id'
      LookupResultField = 'category_name'
      KeyFields = 'category_id'
      LookupCache = True
      Lookup = True
    end
  end
  object ADODataSetEmployee: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_employee'
    Parameters = <>
    Left = 72
    Top = 330
  end
  object ADODataSetRegistered: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_registered'
    Parameters = <>
    Left = 303
    Top = 333
  end
  object ADODataSetExtra: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_extra'
    Parameters = <>
    Left = 75
    Top = 393
  end
  object ADODataSetDiscount: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_discount'
    Parameters = <>
    Left = 72
    Top = 265
  end
  object ADODataSetClientList: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_client'
    Parameters = <>
    Left = 72
    Top = 207
  end
  object ADODataSetBlacklist: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_blacklist'
    Parameters = <>
    Left = 72
    Top = 75
    object ADODataSetBlacklistid: TAutoIncField
      FieldName = 'id'
      ReadOnly = True
      Visible = False
    end
    object ADODataSetBlacklistreservation_id: TIntegerField
      FieldName = 'reservation_id'
    end
    object ADODataSetBlacklistclient_id: TIntegerField
      FieldName = 'client_id'
      Visible = False
    end
    object ADODataSetBlacklistentry_date: TStringField
      FieldName = 'entry_date'
      Size = 10
    end
    object ADODataSetBlacklistClientName: TStringField
      FieldKind = fkLookup
      FieldName = 'ClientName'
      LookupDataSet = ADODataSetClientList
      LookupKeyFields = 'id'
      LookupResultField = 'client_name'
      KeyFields = 'client_id'
      Lookup = True
    end
  end
  object ADODataSetCategory: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_category'
    Parameters = <>
    Left = 72
    Top = 141
  end
  object ADODataSetOrientation: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_orientation'
    Parameters = <>
    Left = 303
    Top = 207
  end
  object ADODataSetRoom: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_room'
    Parameters = <>
    Left = 300
    Top = 387
    object ADODataSetRoomid: TAutoIncField
      FieldName = 'id'
      ReadOnly = True
      Visible = False
    end
    object ADODataSetRoomidentification: TStringField
      FieldName = 'identification'
      Size = 10
    end
    object ADODataSetRoomorientation_id: TIntegerField
      FieldName = 'orientation_id'
      Visible = False
    end
    object ADODataSetRoomtp_id: TIntegerField
      FieldName = 'tp_id'
      Visible = False
    end
    object ADODataSetRoomTypeName: TStringField
      FieldKind = fkLookup
      FieldName = 'TypeName'
      LookupDataSet = ADODataSetRoomType
      LookupKeyFields = 'id'
      LookupResultField = 'tp_name'
      KeyFields = 'tp_id'
      LookupCache = True
      Lookup = True
    end
    object ADODataSetRoomOriName: TStringField
      FieldKind = fkLookup
      FieldName = 'OriName'
      LookupDataSet = ADODataSetOrientation
      LookupKeyFields = 'id'
      LookupResultField = 'orientation'
      KeyFields = 'orientation_id'
      LookupCache = True
      Lookup = True
    end
  end
  object ADODataSetServices: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_service'
    Parameters = <>
    Left = 555
    Top = 132
  end
  object ADODataSetRoomType: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_type'
    Parameters = <>
    Left = 552
    Top = 72
  end
  object DSTax: TDataSource
    DataSet = ADODataSetTax
    Left = 684
    Top = 193
  end
  object DSExtra: TDataSource
    DataSet = ADODataSetExtra
    Left = 192
    Top = 396
  end
  object DSEmployee: TDataSource
    DataSet = ADODataSetEmployee
    Left = 195
    Top = 333
  end
  object DSDiscount: TDataSource
    DataSet = ADODataSetDiscount
    Left = 192
    Top = 264
  end
  object DSClientList: TDataSource
    DataSet = ADODataSetClientList
    Left = 189
    Top = 204
  end
  object DSBlacklist: TDataSource
    DataSet = ADODataSetBlacklist
    Left = 189
    Top = 78
  end
  object DSRegistered: TDataSource
    DataSet = ADODataSetRegistered
    Left = 429
    Top = 339
  end
  object DSService: TDataSource
    DataSet = ADODataSetServices
    Left = 684
    Top = 126
  end
  object DSCategories: TDataSource
    DataSet = ADODataSetCategory
    Left = 189
    Top = 141
  end
  object DSProducts: TDataSource
    DataSet = ADODataSetProducts
    Left = 429
    Top = 264
  end
  object DSOrientation: TDataSource
    DataSet = ADODataSetOrientation
    Left = 429
    Top = 207
  end
  object DSRoomType: TDataSource
    DataSet = ADODataSetRoomType
    Left = 687
    Top = 72
  end
  object DSRoom: TDataSource
    DataSet = ADODataSetRoom
    Left = 429
    Top = 387
  end
  object DSLogType: TDataSource
    DataSet = ADODataSetLogType
    Left = 429
    Top = 135
  end
  object ADODataSetLogType: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_log_type ORDER BY id'
    Parameters = <>
    Left = 303
    Top = 141
    object ADODataSetLogTypeid: TAutoIncField
      FieldName = 'id'
      ReadOnly = True
    end
    object ADODataSetLogTypetp_name: TWideStringField
      FieldName = 'tp_name'
      FixedChar = True
      Size = 50
    end
  end
  object ADODataSetLog: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_log'
    Parameters = <>
    Left = 300
    Top = 78
  end
  object DSLog: TDataSource
    DataSet = ADODataSetLog
    Left = 429
    Top = 78
  end
  object ADOQueryAuthenticate: TADOQuery
    Connection = Conn
    Parameters = <
      item
        Name = 'usrn'
        DataType = ftString
        NumericScale = 255
        Precision = 255
        Size = 50
        Value = Null
      end
      item
        Name = 'pass'
        DataType = ftString
        NumericScale = 255
        Precision = 255
        Size = 32
        Value = Null
      end>
    SQL.Strings = (
      
        'SELECT id, emp_type FROM tbl_employee WHERE emp_username = :usrn' +
        ' AND emp_password = :pass')
    Left = 75
    Top = 477
  end
  object ADODataSetReservation: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_reservation'
    Parameters = <>
    Left = 552
    Top = 330
    object ADODataSetReservationid: TAutoIncField
      FieldName = 'id'
      ReadOnly = True
    end
    object ADODataSetReservationclient_id: TIntegerField
      FieldName = 'client_id'
    end
    object ADODataSetReservationemployee_id: TIntegerField
      FieldName = 'employee_id'
    end
    object ADODataSetReservationregistered_id: TIntegerField
      FieldName = 'registered_id'
    end
    object ADODataSetReservationreservation_date: TStringField
      FieldName = 'reservation_date'
      Size = 10
    end
    object ADODataSetReservationdestination_date: TStringField
      FieldName = 'destination_date'
      Size = 10
    end
    object ADODataSetReservationsecond_choise: TStringField
      FieldName = 'second_choise'
      Size = 1
    end
  end
  object ADODataSetSale: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_sale'
    Parameters = <>
    Left = 555
    Top = 264
    object ADODataSetSaleid: TAutoIncField
      FieldName = 'id'
      ReadOnly = True
    end
    object ADODataSetSalesale_date: TStringField
      FieldName = 'sale_date'
      Size = 10
    end
    object ADODataSetSaleprice: TBCDField
      FieldName = 'price'
      Precision = 10
    end
    object ADODataSetSalepayed: TBCDField
      FieldName = 'payed'
      Precision = 10
    end
    object ADODataSetSaleemployee_id: TIntegerField
      FieldName = 'employee_id'
      Visible = False
    end
    object ADODataSetSaleclient_id: TIntegerField
      FieldName = 'client_id'
      Visible = False
    end
    object ADODataSetSaleClientName: TStringField
      FieldKind = fkLookup
      FieldName = 'ClientName'
      LookupDataSet = ADODataSetClientList
      LookupKeyFields = 'id'
      LookupResultField = 'client_name'
      KeyFields = 'client_id'
      Lookup = True
    end
    object ADODataSetSaleEmployeeUser: TStringField
      FieldKind = fkLookup
      FieldName = 'EmployeeUser'
      LookupDataSet = ADODataSetEmployee
      LookupKeyFields = 'id'
      LookupResultField = 'emp_username'
      KeyFields = 'employee_id'
      Lookup = True
    end
  end
  object DSSale: TDataSource
    DataSet = ADODataSetSale
    Left = 681
    Top = 267
  end
  object ADOCommandDeleteLog: TADOCommand
    CommandText = 'DELETE FROM tbl_log'
    Connection = Conn
    Parameters = <>
    Left = 204
    Top = 474
  end
  object ADOQueryGeneric: TADOQuery
    Connection = Conn
    Parameters = <>
    Left = 312
    Top = 474
  end
  object ADODataSetCheckout: TADODataSet
    Connection = Conn
    CursorType = ctStatic
    CommandText = 'SELECT * FROM tbl_sell'
    Parameters = <>
    Left = 558
    Top = 396
  end
  object DSCheckout: TDataSource
    DataSet = ADODataSetCheckout
    Left = 684
    Top = 396
  end
end
