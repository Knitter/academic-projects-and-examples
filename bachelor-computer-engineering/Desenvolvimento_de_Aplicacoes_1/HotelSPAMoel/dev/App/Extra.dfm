object ExtraForm: TExtraForm
  Tag = 6
  Left = 0
  Top = 0
  BorderIcons = [biSystemMenu, biMinimize]
  BorderStyle = bsSingle
  Caption = 'Extras'
  ClientHeight = 276
  ClientWidth = 344
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
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 328
    Height = 227
    Caption = 'Extras'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clNavy
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    Padding.Left = 5
    Padding.Top = 15
    Padding.Right = 5
    Padding.Bottom = 5
    ParentFont = False
    TabOrder = 0
    object DBGTax: TDBGrid
      Left = 8
      Top = 18
      Width = 312
      Height = 170
      DataSource = HotelGestDataModule.DSExtra
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      TitleFont.Charset = DEFAULT_CHARSET
      TitleFont.Color = clNavy
      TitleFont.Height = -11
      TitleFont.Name = 'Tahoma'
      TitleFont.Style = []
      Columns = <
        item
          Expanded = False
          FieldName = 'extra_name'
          Title.Caption = 'Nome'
          Width = 136
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'price'
          Title.Caption = 'Pre'#231'o'
          Visible = True
        end>
    end
    object DBNav: TDBNavigator
      Left = 8
      Top = 194
      Width = 225
      Height = 25
      DataSource = HotelGestDataModule.DSExtra
      VisibleButtons = [nbFirst, nbPrior, nbNext, nbLast, nbInsert, nbDelete, nbPost, nbCancel, nbRefresh]
      TabOrder = 1
    end
  end
  object BTNClose: TBitBtn
    Left = 261
    Top = 241
    Width = 75
    Height = 27
    Caption = 'Fechar'
    TabOrder = 1
    OnClick = BTNCloseClick
  end
end
