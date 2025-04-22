object ClientListForm: TClientListForm
  Tag = 3
  Left = 0
  Top = 0
  Caption = 'Clientes'
  ClientHeight = 425
  ClientWidth = 569
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
  DesignSize = (
    569
    425)
  PixelsPerInch = 96
  TextHeight = 13
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 553
    Height = 50
    Anchors = [akLeft, akTop, akRight]
    Caption = 'Pesquisa'
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
    object Label1: TLabel
      Left = 8
      Top = 21
      Width = 31
      Height = 13
      Caption = 'Nome:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 186
      Top = 21
      Width = 80
      Height = 13
      Caption = 'Ou Contribuinte:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
    end
    object EDTNameSearch: TEdit
      Left = 45
      Top = 18
      Width = 135
      Height = 21
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      OnEnter = EDTNameSearchEnter
    end
    object BTNSearch: TButton
      Left = 399
      Top = 16
      Width = 70
      Height = 25
      Caption = 'Procurar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      OnClick = BTNSearchClick
    end
    object EDTNumberSearch: TEdit
      Left = 272
      Top = 18
      Width = 121
      Height = 21
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      TabOrder = 2
      OnEnter = EDTNumberSearchEnter
    end
    object BTNSeeAll: TButton
      Left = 475
      Top = 16
      Width = 70
      Height = 25
      Caption = 'Ver Todos'
      TabOrder = 3
      OnClick = BTNSeeAllClick
    end
  end
  object GroupBox2: TGroupBox
    Left = 8
    Top = 64
    Width = 553
    Height = 354
    Anchors = [akLeft, akTop, akRight, akBottom]
    Caption = 'Lista de Clientes'
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
    TabOrder = 1
    DesignSize = (
      553
      354)
    object DBGClientList: TDBGrid
      Left = 8
      Top = 18
      Width = 537
      Height = 297
      Anchors = [akLeft, akTop, akRight, akBottom]
      DataSource = HotelGestDataModule.DSClientList
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
          FieldName = 'id'
          Title.Caption = 'N'#250'mero'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'client_name'
          Title.Caption = 'Nome'
          Width = 100
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'registration_number'
          Title.Caption = 'Contribuinte'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'phone'
          Title.Caption = 'Telefone'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'cellphone'
          Title.Caption = 'Telem'#243'vel'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'fax'
          Title.Caption = 'Fax'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'email'
          Title.Caption = 'E-mail'
          Width = 100
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'address'
          Title.Caption = 'Endere'#231'o'
          Width = 100
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'zip_code'
          Title.Caption = 'C'#243'digo Postal'
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'city'
          Title.Caption = 'Cidade'
          Width = 100
          Visible = True
        end
        item
          Expanded = False
          FieldName = 'client_type'
          Title.Caption = 'Tipo Cliente'
          Visible = True
        end>
    end
    object DBNav: TDBNavigator
      Left = 8
      Top = 321
      Width = 232
      Height = 25
      DataSource = HotelGestDataModule.DSClientList
      VisibleButtons = [nbFirst, nbPrior, nbNext, nbLast, nbDelete, nbPost, nbCancel, nbRefresh]
      Anchors = [akLeft, akBottom]
      TabOrder = 1
    end
    object BTNClose: TButton
      Left = 470
      Top = 321
      Width = 75
      Height = 25
      Anchors = [akRight, akBottom]
      Caption = 'Fechar'
      TabOrder = 2
      OnClick = BTNCloseClick
    end
  end
end
