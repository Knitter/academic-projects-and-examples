object BookingForm: TBookingForm
  Tag = 2
  Left = 0
  Top = 0
  BorderIcons = [biSystemMenu, biMinimize]
  BorderStyle = bsSingle
  Caption = 'Entradas'
  ClientHeight = 236
  ClientWidth = 369
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
  object PageControl1: TPageControl
    Left = 0
    Top = 0
    Width = 625
    Height = 373
    ActivePage = TabSheet4
    TabOrder = 0
    object TabSheet1: TTabSheet
      TabVisible = False
      object GroupBox2: TGroupBox
        Left = 3
        Top = 3
        Width = 355
        Height = 190
        Caption = 'Entrada de'
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
        object RBNew: TRadioButton
          Left = 8
          Top = 18
          Width = 113
          Height = 17
          Caption = 'H'#243'spede Novo'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 0
        end
        object RBFormerGuest: TRadioButton
          Left = 8
          Top = 64
          Width = 113
          Height = 17
          Caption = 'H'#243'spede Anterior'
          Enabled = False
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 1
        end
        object RBFomerClient: TRadioButton
          Left = 8
          Top = 87
          Width = 113
          Height = 17
          Caption = 'Cliente Anterior'
          Enabled = False
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 2
        end
        object RBReservation: TRadioButton
          Left = 8
          Top = 41
          Width = 113
          Height = 17
          Caption = 'Reserva'
          Enabled = False
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 3
        end
      end
      object BTNPage1Forward: TButton
        Left = 172
        Top = 199
        Width = 90
        Height = 25
        Caption = 'Avancar >>'
        TabOrder = 1
        OnClick = BTNPage1ForwardClick
      end
      object BTNCancel: TButton
        Left = 268
        Top = 199
        Width = 90
        Height = 25
        Caption = 'Cancelar'
        TabOrder = 2
        OnClick = BTNCancelClick
      end
    end
    object TabSheet2: TTabSheet
      ImageIndex = 1
      TabVisible = False
      object GroupBox1: TGroupBox
        Left = 3
        Top = 3
        Width = 355
        Height = 190
        Caption = 'H'#243'spede'
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
          Top = 75
          Width = 14
          Height = 13
          Caption = 'BI:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label2: TLabel
          Left = 8
          Top = 48
          Width = 39
          Height = 13
          Caption = 'Apelido:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label3: TLabel
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
        object Label13: TLabel
          Left = 8
          Top = 156
          Width = 32
          Height = 13
          Caption = 'E-mail:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label14: TLabel
          Left = 8
          Top = 129
          Width = 52
          Height = 13
          Caption = 'Telem'#243'vel:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label19: TLabel
          Left = 8
          Top = 102
          Width = 46
          Height = 13
          Caption = 'Telefone:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object EDTRegisteredName: TEdit
          Left = 66
          Top = 18
          Width = 281
          Height = 21
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 0
        end
        object EDTRegisteredSurname: TEdit
          Left = 66
          Top = 45
          Width = 281
          Height = 21
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 1
        end
        object MSKRegisteredID: TMaskEdit
          Left = 66
          Top = 72
          Width = 121
          Height = 21
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 2
        end
        object MSKRegisteredPhone: TMaskEdit
          Left = 66
          Top = 99
          Width = 121
          Height = 21
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 3
        end
        object MSKRegisteredCellphone: TMaskEdit
          Left = 66
          Top = 126
          Width = 121
          Height = 21
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 4
        end
        object EDTRegisteredMail: TEdit
          Left = 66
          Top = 153
          Width = 281
          Height = 21
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 5
        end
      end
      object BTNPage2Forward: TButton
        Left = 268
        Top = 199
        Width = 90
        Height = 25
        Caption = 'Avan'#231'ar >>'
        TabOrder = 1
        OnClick = BTNPage2ForwardClick
      end
      object BTNPage2Back: TButton
        Left = 172
        Top = 199
        Width = 90
        Height = 25
        Caption = '<< Retroceder'
        TabOrder = 2
        OnClick = BTNPage2BackClick
      end
    end
    object TabSheet3: TTabSheet
      ImageIndex = 2
      TabVisible = False
      object GroupBox4: TGroupBox
        Left = 3
        Top = 3
        Width = 355
        Height = 190
        Caption = 'Estadia'
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
        object Label6: TLabel
          Left = 8
          Top = 75
          Width = 30
          Height = 13
          Caption = 'Sa'#237'da:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label7: TLabel
          Left = 8
          Top = 48
          Width = 42
          Height = 13
          Caption = 'Entrada:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label8: TLabel
          Left = 8
          Top = 21
          Width = 24
          Height = 13
          Caption = 'Dias:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label9: TLabel
          Left = 8
          Top = 102
          Width = 49
          Height = 13
          Caption = 'Desconto:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object Label10: TLabel
          Left = 8
          Top = 129
          Width = 21
          Height = 13
          Caption = 'IVA:'
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
        end
        object UpDown1: TUpDown
          Left = 106
          Top = 18
          Width = 16
          Height = 21
          Associate = EDTDays
          TabOrder = 0
        end
        object EDTDays: TEdit
          Left = 63
          Top = 18
          Width = 43
          Height = 21
          BiDiMode = bdRightToLeft
          ParentBiDiMode = False
          TabOrder = 1
          Text = '0'
        end
        object DateTimePicker1: TDateTimePicker
          Left = 63
          Top = 45
          Width = 145
          Height = 21
          Date = 39328.256752199070000000
          Time = 39328.256752199070000000
          TabOrder = 2
        end
        object DateTimePicker2: TDateTimePicker
          Left = 63
          Top = 72
          Width = 145
          Height = 21
          Date = 39328.256752199070000000
          Time = 39328.256752199070000000
          TabOrder = 3
        end
        object DBLookupComboBox1: TDBLookupComboBox
          Left = 63
          Top = 99
          Width = 145
          Height = 21
          DataSource = HotelGestDataModule.DSDiscount
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 4
        end
        object DBLookupComboBox2: TDBLookupComboBox
          Left = 63
          Top = 126
          Width = 145
          Height = 21
          DataSource = HotelGestDataModule.DSTax
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ParentFont = False
          TabOrder = 5
        end
      end
      object BTNPage3Forward: TButton
        Left = 268
        Top = 199
        Width = 90
        Height = 25
        Caption = 'Avan'#231'ar >>'
        TabOrder = 1
        OnClick = BTNPage3ForwardClick
      end
      object BTNPage3Back: TButton
        Left = 172
        Top = 199
        Width = 90
        Height = 25
        Caption = '<< Retroceder'
        TabOrder = 2
        OnClick = BTNPage3BackClick
      end
    end
    object TabSheet4: TTabSheet
      ImageIndex = 3
      TabVisible = False
      object GroupBox3: TGroupBox
        Left = 3
        Top = 3
        Width = 355
        Height = 190
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
        object DBGrid1: TDBGrid
          Left = 8
          Top = 18
          Width = 179
          Height = 164
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
              Title.Caption = 'Extra'
              Width = 80
              Visible = True
            end
            item
              Expanded = False
              FieldName = 'price'
              Title.Caption = 'Pre'#231'o'
              Visible = True
            end>
        end
        object BTNAddExtra: TButton
          Left = 193
          Top = 18
          Width = 24
          Height = 37
          Caption = '>'
          TabOrder = 1
          OnClick = BTNAddExtraClick
        end
        object LSBExtras: TListBox
          Left = 223
          Top = 18
          Width = 124
          Height = 164
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          ItemHeight = 13
          ParentFont = False
          TabOrder = 2
        end
        object BTNRemoveExtra: TButton
          Left = 193
          Top = 61
          Width = 24
          Height = 37
          Caption = '<'
          TabOrder = 3
          OnClick = BTNRemoveExtraClick
        end
      end
      object BTNPage4Forward: TButton
        Left = 268
        Top = 199
        Width = 90
        Height = 25
        Caption = 'Avan'#231'ar >>'
        TabOrder = 1
        OnClick = BTNPage4ForwardClick
      end
      object BTNPage4Back: TButton
        Left = 172
        Top = 199
        Width = 90
        Height = 25
        Caption = '<< Retroceder'
        TabOrder = 2
        OnClick = BTNPage4BackClick
      end
    end
    object TabSheet5: TTabSheet
      ImageIndex = 4
      TabVisible = False
      object BTNFinish: TButton
        Left = 268
        Top = 199
        Width = 90
        Height = 25
        Caption = 'Concluir'
        TabOrder = 0
        OnClick = BTNFinishClick
      end
      object BTNPage5Back: TButton
        Left = 172
        Top = 199
        Width = 90
        Height = 25
        Caption = '<< Retroceder'
        TabOrder = 1
        OnClick = BTNPage5BackClick
      end
      object GroupBox5: TGroupBox
        Left = 3
        Top = 3
        Width = 355
        Height = 190
        Caption = 'Resumo'
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
        TabOrder = 2
        object Memo1: TMemo
          Left = 8
          Top = 18
          Width = 339
          Height = 164
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clWindowText
          Font.Height = -11
          Font.Name = 'Tahoma'
          Font.Style = []
          Lines.Strings = (
            'Memo1')
          ParentFont = False
          TabOrder = 0
        end
      end
    end
  end
end
