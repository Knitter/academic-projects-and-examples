object LoginForm: TLoginForm
  Left = 0
  Top = 0
  BorderStyle = bsToolWindow
  Caption = 'LoginForm'
  ClientHeight = 94
  ClientWidth = 245
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  Position = poOwnerFormCenter
  PixelsPerInch = 96
  TextHeight = 13
  object lblUsername: TLabel
    Left = 8
    Top = 11
    Width = 48
    Height = 13
    Caption = 'Utilizador:'
  end
  object lblPassword: TLabel
    Left = 8
    Top = 38
    Width = 72
    Height = 13
    Caption = 'Palavra-passe:'
  end
  object edtUsername: TEdit
    Left = 86
    Top = 8
    Width = 146
    Height = 21
    TabOrder = 0
  end
  object btnOK: TButton
    Left = 157
    Top = 62
    Width = 75
    Height = 25
    Caption = 'OK'
    TabOrder = 1
    OnClick = btnOKClick
  end
  object mskPassword: TMaskEdit
    Left = 86
    Top = 35
    Width = 146
    Height = 21
    PasswordChar = '#'
    TabOrder = 2
  end
end
