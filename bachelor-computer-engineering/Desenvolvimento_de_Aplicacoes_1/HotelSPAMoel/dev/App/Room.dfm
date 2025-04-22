object RoomForm: TRoomForm
  Tag = 11
  Left = 0
  Top = 0
  Caption = 'Gest'#227'o de Quartos'
  ClientHeight = 363
  ClientWidth = 486
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
    486
    363)
  PixelsPerInch = 96
  TextHeight = 13
  object BTNClose: TButton
    Left = 403
    Top = 330
    Width = 75
    Height = 25
    Anchors = [akRight, akBottom]
    Caption = 'Fechar'
    TabOrder = 0
    OnClick = BTNCloseClick
  end
  object PageControl1: TPageControl
    Left = 0
    Top = 0
    Width = 487
    Height = 324
    ActivePage = TabSheet1
    Anchors = [akLeft, akTop, akRight, akBottom]
    TabOrder = 1
    object TabSheet1: TTabSheet
      Caption = 'Quartos'
      DesignSize = (
        479
        296)
      object GroupBox1: TGroupBox
        Left = 3
        Top = 3
        Width = 471
        Height = 290
        Anchors = [akLeft, akTop, akRight, akBottom]
        Caption = 'Quartos'
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
          471
          290)
        object DBGRoom: TDBGrid
          Left = 8
          Top = 18
          Width = 448
          Height = 233
          Anchors = [akLeft, akTop, akRight, akBottom]
          DataSource = HotelGestDataModule.DSRoom
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
              FieldName = 'identification'
              Title.Caption = 'Quarto'
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'TypeName'
              Title.Caption = 'Tipo'
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'OriName'
              Title.Caption = 'Orienta'#231#227'o'
              Visible = True
            end>
        end
        object DBNavRoom: TDBNavigator
          Left = 8
          Top = 257
          Width = 240
          Height = 25
          DataSource = HotelGestDataModule.DSRoom
          Anchors = [akLeft, akBottom]
          TabOrder = 1
        end
      end
    end
    object TabSheet2: TTabSheet
      Caption = 'Tipos'
      ImageIndex = 1
      ExplicitLeft = 0
      ExplicitTop = 0
      ExplicitWidth = 0
      ExplicitHeight = 0
      DesignSize = (
        479
        296)
      object GroupBox2: TGroupBox
        Left = 3
        Top = 3
        Width = 471
        Height = 290
        Anchors = [akLeft, akTop, akRight, akBottom]
        Caption = 'Tipos de Quarto'
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
          471
          290)
        object DBGRoomType: TDBGrid
          Left = 8
          Top = 18
          Width = 455
          Height = 233
          Anchors = [akLeft, akTop, akRight, akBottom]
          DataSource = HotelGestDataModule.DSRoomType
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
              FieldName = 'tp_name'
              Title.Caption = 'Tipo de Quarto'
              Width = 128
              Visible = True
            end>
        end
        object DBNavRoomType: TDBNavigator
          Left = 8
          Top = 257
          Width = 240
          Height = 25
          DataSource = HotelGestDataModule.DSRoomType
          Anchors = [akLeft, akBottom]
          TabOrder = 1
        end
      end
    end
    object TabSheet3: TTabSheet
      Caption = 'Orienta'#231#245'es'
      ImageIndex = 2
      ExplicitLeft = 0
      ExplicitTop = 0
      ExplicitWidth = 0
      ExplicitHeight = 0
      DesignSize = (
        479
        296)
      object GroupBox3: TGroupBox
        Left = 3
        Top = 3
        Width = 471
        Height = 290
        Anchors = [akLeft, akTop, akRight, akBottom]
        Caption = 'Orienta'#231#227'o dos Quartos'
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
          471
          290)
        object DBGOrientation: TDBGrid
          Left = 8
          Top = 18
          Width = 455
          Height = 233
          Anchors = [akLeft, akTop, akRight, akBottom]
          DataSource = HotelGestDataModule.DSOrientation
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
              FieldName = 'orientation'
              Title.Caption = 'Orienta'#231#227'o do Quarto'
              Width = 121
              Visible = True
            end>
        end
        object DBNavOrientation: TDBNavigator
          Left = 8
          Top = 257
          Width = 240
          Height = 25
          DataSource = HotelGestDataModule.DSOrientation
          Anchors = [akLeft, akBottom]
          TabOrder = 1
        end
      end
    end
  end
end
