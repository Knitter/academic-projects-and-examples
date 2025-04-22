object ProductNServiceForm: TProductNServiceForm
  Tag = 8
  Left = 0
  Top = 0
  Caption = 'Gest'#227'o de Produtos'
  ClientHeight = 395
  ClientWidth = 495
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
    495
    395)
  PixelsPerInch = 96
  TextHeight = 13
  object PageControl1: TPageControl
    Left = 0
    Top = 0
    Width = 496
    Height = 358
    ActivePage = TabSheet1
    Anchors = [akLeft, akTop, akRight, akBottom]
    TabOrder = 0
    object TabSheet1: TTabSheet
      Caption = 'Produtos'
      DesignSize = (
        488
        330)
      object GroupBox1: TGroupBox
        Left = 3
        Top = 3
        Width = 480
        Height = 325
        Anchors = [akLeft, akTop, akRight, akBottom]
        Caption = 'Produtos'
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
        DesignSize = (
          480
          325)
        object DBGrid1: TDBGrid
          Left = 8
          Top = 18
          Width = 464
          Height = 271
          Anchors = [akLeft, akTop, akRight, akBottom]
          DataSource = HotelGestDataModule.DSProducts
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
        end
        object DBNavProducts: TDBNavigator
          Left = 8
          Top = 295
          Width = 240
          Height = 25
          DataSource = HotelGestDataModule.DSProducts
          Anchors = [akLeft, akBottom]
          TabOrder = 1
        end
      end
    end
    object TabSheet2: TTabSheet
      Caption = 'Categorias'
      ImageIndex = 1
      DesignSize = (
        488
        330)
      object GroupBox2: TGroupBox
        Left = 3
        Top = 3
        Width = 480
        Height = 325
        Anchors = [akLeft, akTop, akRight, akBottom]
        Caption = 'Categorias de Produtos'
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
        DesignSize = (
          480
          325)
        object DBGrid2: TDBGrid
          Left = 8
          Top = 18
          Width = 464
          Height = 271
          Anchors = [akLeft, akTop, akRight, akBottom]
          DataSource = HotelGestDataModule.DSCategories
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
              FieldName = 'category_name'
              Title.Caption = 'Categoria'
              Visible = True
            end>
        end
        object DBNavigator1: TDBNavigator
          Left = 8
          Top = 295
          Width = 240
          Height = 25
          DataSource = HotelGestDataModule.DSCategories
          Anchors = [akLeft, akBottom]
          TabOrder = 1
        end
      end
    end
    object TabSheet3: TTabSheet
      Caption = 'Servi'#231'os'
      ImageIndex = 2
      DesignSize = (
        488
        330)
      object GroupBox3: TGroupBox
        Left = 3
        Top = 3
        Width = 480
        Height = 325
        Anchors = [akLeft, akTop, akRight, akBottom]
        Caption = 'Servi'#231'os'
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
        DesignSize = (
          480
          325)
        object DBGrid3: TDBGrid
          Left = 8
          Top = 18
          Width = 464
          Height = 271
          Anchors = [akLeft, akTop, akRight, akBottom]
          DataSource = HotelGestDataModule.DSService
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
              FieldName = 'serv_name'
              Title.Caption = 'Servi'#231'o'
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'price'
              Title.Caption = 'Pre'#231'o'
              Visible = True
            end>
        end
        object DBNavigator2: TDBNavigator
          Left = 8
          Top = 295
          Width = 240
          Height = 25
          DataSource = HotelGestDataModule.DSService
          Anchors = [akLeft, akBottom]
          TabOrder = 1
        end
      end
    end
  end
  object BTNClose: TButton
    Left = 412
    Top = 364
    Width = 75
    Height = 25
    Anchors = [akRight, akBottom]
    Caption = 'Fechar'
    TabOrder = 1
    OnClick = BTNCloseClick
  end
end
