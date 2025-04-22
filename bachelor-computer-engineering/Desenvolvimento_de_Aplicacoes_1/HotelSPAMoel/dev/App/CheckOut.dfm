object CheckOutForm: TCheckOutForm
  Tag = 13
  Left = 0
  Top = 0
  Caption = 'Sa'#237'das'
  ClientHeight = 320
  ClientWidth = 341
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  FormStyle = fsMDIChild
  OldCreateOrder = False
  Visible = True
  OnClose = FormClose
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 326
    Height = 308
    Caption = 'Sa'#237'das'
    Padding.Left = 5
    Padding.Top = 15
    Padding.Right = 5
    Padding.Bottom = 5
    TabOrder = 0
    object DBGrid1: TDBGrid
      Left = 8
      Top = 18
      Width = 308
      Height = 251
      DataSource = HotelGestDataModule.DSCheckout
      TabOrder = 0
      TitleFont.Charset = DEFAULT_CHARSET
      TitleFont.Color = clWindowText
      TitleFont.Height = -11
      TitleFont.Name = 'Tahoma'
      TitleFont.Style = []
      Columns = <
        item
          Expanded = False
          FieldName = 'stay_id'
          Title.Caption = 'Estadia'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'sale_id'
          Title.Caption = 'Venda'
          Visible = True
        end>
    end
    object DBNavigator1: TDBNavigator
      Left = 8
      Top = 275
      Width = 240
      Height = 25
      DataSource = HotelGestDataModule.DSCheckout
      TabOrder = 1
    end
  end
end
